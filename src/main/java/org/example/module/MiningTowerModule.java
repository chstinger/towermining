package org.example.module;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.TowerModule;
import org.example.util.Const;

@EqualsAndHashCode(callSuper = true)
@Data
public class MiningTowerModule extends TowerModule {

    private float miningR= Const.miningR;
    private float miningRDelta=1.0f;

    public MiningTowerModule() {
        setName("Mining");
    }

    @Override
    public boolean update(float delta) {
        if (!super.update(delta))
            return false;
        miningR+=miningRDelta*delta;
        return true;
    }
}
