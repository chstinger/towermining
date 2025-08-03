package org.example;

import org.example.agent.AiAgent;
import org.example.agent.EnvAgent;
import org.example.agent.UiTowerAgent;
import org.example.api.ApplicationListener;
import org.example.gdx.Gdx;
import org.example.model.*;

import java.text.MessageFormat;

public class GameTowerDefend implements ApplicationListener {

    private World world;
    private AwtControlDemo awtControlDemo;

    @Override
    public void create() {

        awtControlDemo=new AwtControlDemo();
        awtControlDemo.showTextAreaDemo();
        world = new World(new UiTowerAgent(new Tower()),new AiAgent(new Army()),new EnvAgent(new Army()));
        World.setInstance(world);
        //Todo load from json


    }

    public boolean isStop() {
        return awtControlDemo.isStop();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        input(delta);
        logic(delta);
        draw(delta);

    }

    private void input(float delta) {
        world.handleInput();

    }

    private void logic(float delta) {
        world.update(delta);

    }

    float time=0;
    private void draw(float delta) {

        StringBuffer sb=new StringBuffer();
        time+=delta;
        sb.append("Time "+ formatFloat(time) +"\n");
        for (TowerModule towerModule : World.getInstance().getTower().getTowerModules()) {
            String s= towerModule.getName()+" Tθ="+towerModule.getTargetPosTheta();
            for (Cone cone : towerModule.getCones()) {
                s+="\tθ="+ formatFloat(cone.getPos().getTheta());
            }
            sb.append(s+"\n");

        }

        sb.append("------------"+"\n");
        String s="Actors:";
        for (Actor actor : World.getInstance().getActors()) {
            s+="\t θ="+ formatFloat(actor.getPos().getTheta()) +" r="+formatFloat(actor.getPos().getR());
        }
        sb.append(s+"\n");
        s="Ordnance:";
        for (Ordnance ordnance : World.getInstance().getOrdnances()) {
            s+="\t θ="+ formatFloat(ordnance.getPos().getTheta())+" r="+formatFloat(ordnance.getPos().getR());
        }
        sb.append(s+"\n");
        awtControlDemo.setText(sb.toString());


    }

    private static String formatFloat(float f) {
        return MessageFormat.format("{0,number,#.##}",f);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
