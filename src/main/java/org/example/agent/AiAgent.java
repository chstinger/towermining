package org.example.agent;

import org.example.model.*;
import org.example.util.Const;
import org.example.util.Theta;

public class AiAgent implements Agent{

    private Army army;
    private Tower tower;

    private float deployInterval=2.0f;
    private float deploy=0;
    private float nextDeployTheta=0f;
    private float deployDelta=45f;


    public AiAgent(Army army) {
        this.army = army;
    }

    @Override
    public boolean update(float delta) {
        deploy+=delta;
        if (deploy>deployInterval) {
            World.getInstance().createActor(new Actor(new Polar(Const.deployR,nextDeployTheta),new Polar(-2,0),new Polar(0,0)));
            nextDeployTheta=Theta.addTheta(nextDeployTheta,deployDelta);
            deploy=0;
        }
        return true;
    }


}
