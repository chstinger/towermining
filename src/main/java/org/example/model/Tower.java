
package org.example.model;


import lombok.Data;
import org.example.api.HasUpdate;
import org.example.module.GunTowerModule;
import org.example.module.IntelTowerModule;

import java.util.ArrayList;
import java.util.List;

@Data
public class Tower implements HasUpdate {
    private String name;
    private List<TowerModule> towerModules;

    public Tower() {
        towerModules =new ArrayList<>();
        towerModules.add(new IntelTowerModule());
        towerModules.add(new GunTowerModule());
    }

    @Override
    public boolean update(float delta) {
        for (TowerModule towerModule : towerModules) {
            towerModule.update(delta);
        }
        return true;
    }
}
