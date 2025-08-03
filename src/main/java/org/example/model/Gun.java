package org.example.model;

import lombok.Data;
import org.example.api.ActionCallback;
import org.example.api.HasActionUpdate;

@Data
public class Gun implements HasActionUpdate<Gun> {


    private float deltaR=2; // Speed
    private float damage=1;
    private float splashDamage=0;

    private float reloadTime=2;

    private float reloading=0;

    @Override
    public boolean update(float delta, ActionCallback<Gun> actionCallback) {

        if (reloading>reloadTime) {
            reloading=0;
            // Aquire target
            // Todo can be called to many times
            actionCallback.action(this);
        } else {
            reloading+=delta;
        }

        return false;
    }

    public void fire(Actor actor) {

        World.getInstance().createOrdnance(actor,new Payload(damage,deltaR));

    }
}
