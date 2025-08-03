package org.example.model;

import lombok.Data;
import org.example.api.HasUpdate;
import org.example.util.Const;
import org.example.util.Overlap;

@Data
public class Ordnance implements HasUpdate {
    private Actor target;
    private Payload payload;
    private Polar pos;
    private boolean valid=true;

    public Ordnance(Actor target, Payload payload) {
        this.target = target;
        this.payload = payload;
        pos=new Polar(Const.minR,target.getPos().getTheta());
    }

    @Override
    public boolean update(float delta) {
        if (!valid)
            return false;
        pos.setR(payload.getDeltaR()*delta+pos.getR());
        if (Overlap.overlap(pos,target.getPos())) {
            target.applyPayload(payload);
            valid=false;
        }

        return true;
    }
}
