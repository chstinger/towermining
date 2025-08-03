package org.example.model;

import lombok.Data;
import org.example.api.HasUpdate;
import org.example.util.Theta;

import java.util.ArrayList;
import java.util.List;

@Data
public class TowerModule implements HasUpdate {
    private String name;
    private List<Cone> cones=new ArrayList<>();
    // Current theta
    private float theta=0;

    //private float workingDeltaPosTheta=10f;

    // Change to new position, function not called
    //private float changeDeltaPosTheta=0;
    //private Float targetPosTheta=null;
    private TowerMovementOrder movementOrder=null;

    @Override
    public boolean update(float delta) {
        if (movementOrder!=null) {
            theta=movementOrder.update(theta, delta);
        }
        /*if (targetPosTheta!=null) {
            theta= Theta.addTheta(theta,changeDeltaPosTheta*delta);
            if (Theta.compareTheta(theta,targetPosTheta)) {
                targetPosTheta=null;
            }
        } else {
            theta= Theta.addTheta(theta,workingDeltaPosTheta*delta);
        } */
        for (Cone cone : cones) {
            cone.setTheta(theta);
        }
        return targetPosTheta==null;
    }
}
