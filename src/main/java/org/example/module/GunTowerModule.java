package org.example.module;

import org.example.api.ActionCallback;
import org.example.model.*;
import org.example.util.Const;
import org.example.util.Overlap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GunTowerModule extends TowerModule {


    private List<Gun> guns=new ArrayList<>();

    public GunTowerModule() {
        setName("Gun");
        Cone cone = new Cone();
        cone.setPos(new Polar(Const.maxR/2.0f,0));
        cone.setWidth(new Polar(Const.maxR/2.0f,30));
        getCones().add(cone);
        guns.add(new Gun());
    }


    // Todo individual cones
    @Override
    public boolean update(float delta) {
        if (!super.update(delta)) {
            return false;

        }
        final AtomicBoolean hasTarget=new AtomicBoolean(false);

        for (Gun gun : guns) {
            gun.update(delta, new ActionCallback<Gun>() {
                @Override
                public void action(final Gun gun) {
                    Overlap.overlapConeActor(getCones(), World.getInstance().getActors(), new ActionCallback<Actor>() {
                        @Override
                        public void action(Actor actor) {
                            if (actor.isVisible()) {
                                gun.fire(actor);
                            }
                            hasTarget.set(true);
                        }
                    });
                }
            });
        }
        if (!hasTarget.get() && getTargetPosTheta()==null) {
            if (!World.getInstance().getActors().isEmpty()) {
                setTargetPosTheta(World.getInstance().getActors().getFirst().getPos().getTheta());
                setChangeDeltaPosTheta(90f);
            }
        }

        return true;
    }
}
