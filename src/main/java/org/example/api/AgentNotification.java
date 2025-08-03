package org.example.api;

import org.example.model.Actor;

public interface AgentNotification {

    void newAgent(Actor actor);
    void deleteAgent(Actor actor);

}
