package org.example.model;

import lombok.Data;
import org.example.agent.Agent;
import org.example.api.HasTower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class World {

    private List<Actor> actors =new ArrayList<>();
    private List<Ordnance> ordnances =new ArrayList<>();
    private Tower tower;

    private List<Agent> agents=new ArrayList<>();

    public World(Agent... agents) {
        this.agents=new ArrayList<>(Arrays.asList(agents));
        for (Agent agent : agents) {
            if (agent instanceof HasTower) {
                HasTower hasTower = (HasTower) agent;
                tower=hasTower.getTower();
            }
        }

    }

    private static World instance;

    public static void setInstance(World instance) {
        World.instance = instance;
    }

    public static World getInstance() {
        return instance;
    }

    public void createOrdnance(Actor actor, Payload payload) {
        ordnances.add(new Ordnance(actor,payload));
    }

    public void createActor(Actor actor) {
        actors.add(actor);
    }

    public void handleInput() {

    }

    public void update(float delta) {
        for (Agent agent : agents) {
            agent.update(delta);
        }
        boolean valid=true;
        for (Actor actor : actors) {
            actor.update(delta);
            if (!actor.isValid()) {
                valid=false;
            }
        }
        if (!valid) {
            List<Actor> newActors=new ArrayList<>();
            for (Actor actor : actors) {
                if (actor.isValid())
                    newActors.add(actor);
            }
            actors=newActors;
        }
        valid=true;
        for (Ordnance ordnance : ordnances) {
            ordnance.update(delta);
            if (!ordnance.isValid()) {
                valid=false;
            }
        }
        if (!valid) {
            List<Ordnance> newOrdnance=new ArrayList<>();
            for (Ordnance ordnance : ordnances) {
                if (ordnance.isValid())
                    newOrdnance.add(ordnance);
            }
            ordnances=newOrdnance;
        }
    }
}
