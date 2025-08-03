package org.example.module;

import org.example.api.ActionCallback;
import org.example.model.*;
import org.example.util.Const;
import org.example.util.Overlap;



public class IntelTowerModule extends TowerModule {

    public IntelTowerModule() {
        setMovementOrder(TowerMovementOrder.createRotate(40f));
        setName("Intel");
        // Todo read from json
        Cone e = new Cone();
        e.setPos(new Polar(Const.maxR/2.0f,0));
        e.setWidth(new Polar(Const.maxR/2.0f,30));
        getCones().add(e);
    }

    @Override
    public boolean update(float delta) {
        if (!super.update(delta)) {
            return true;
        }
        Overlap.overlapConeActor(getCones(), World.getInstance().getActors(), new ActionCallback<Actor>() {
            @Override
            public void action(Actor actor) {
                // Todo calculate visible from intel vs stealth combined with range
                actor.setVisible(true);
            }
        });
        return true;
    }



}
