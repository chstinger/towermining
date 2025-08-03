package org.example;

import org.example.gdx.Gdx;
import org.junit.jupiter.api.Test;

public class GameTowerDefendTest {

    @Test
    void testGame() {
        GameTowerDefend gameTowerDefend=new GameTowerDefend();
        gameTowerDefend.create();
        while(!gameTowerDefend.isStop()) {
            gameTowerDefend.render();
            try {
                Thread.sleep((long)(1000* Gdx.graphics.getDeltaTime()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
