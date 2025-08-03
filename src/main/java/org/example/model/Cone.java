package org.example.model;

import lombok.Data;
import org.example.util.Theta;

import java.math.BigDecimal;

@Data
public class Cone {
    private String name;
    private float offsetTheta=0;

    public void setTheta(float theta) {
        pos.setTheta(Theta.addTheta(theta,offsetTheta));
    }

    private Polar pos;
    private Polar width; // degrees

}
