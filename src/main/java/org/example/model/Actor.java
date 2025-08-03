package org.example.model;

import lombok.Data;
import org.example.api.HasUpdate;
import org.example.util.Const;
import org.example.util.Theta;

@Data
public class Actor implements HasUpdate {
    private String name;
    private String description;
    private Polar pos;
    private Polar deltaPos;
    // Width is a calculated from carthesian coordiantes
    private Polar width;
    private boolean visible;
    private Alignment alignment;
    private boolean valid=true;


    public Actor(Polar pos, Polar width) {
        this.pos = pos;
        this.width = width;
    }

    public Actor(Polar pos, Polar deltaPos, Polar width) {
        this.pos = pos;
        this.deltaPos = deltaPos;
        this.width = width;
    }

    @Override
    public boolean update(float delta) {
        if (deltaPos != null) {
            pos.setTheta(Theta.addTheta(pos.getTheta(), deltaPos.getTheta()*delta));
            pos.setR(pos.getR() + deltaPos.getR()*delta);
            if (pos.getR() < Const.minR) {
                // Todo Notify min hit
                valid=false;
            } else if (pos.getR() > Const.maxR) {
                // Todo Notify max hit
            } else {
                // Todo check obstacles
            }
            return true;
        }
        return true;
    }

    public void applyPayload(Payload payload) {

    }
}
