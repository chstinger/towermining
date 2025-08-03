package org.example.agent;

import org.example.model.Army;

// Controls monster in the ground
public class EnvAgent implements Agent{

    private Army army;

    public EnvAgent(Army army) {
        this.army = army;
    }

    @Override
    public boolean update(float delta) {
        return true;

    }
}
