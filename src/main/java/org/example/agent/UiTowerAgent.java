package org.example.agent;

import lombok.Getter;
import org.example.api.HasTower;
import org.example.model.Tower;

@Getter
public class UiTowerAgent implements Agent, HasTower {

    private Tower tower;

    public UiTowerAgent(Tower tower) {
        this.tower = tower;
    }

    @Override
    public boolean update(float delta) {
        return this.tower.update(delta);

    }
}
