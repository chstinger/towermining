package org.example;

import org.example.model.Actor;
import org.example.model.Polar;
import org.example.util.Overlap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    @Test
    void testAgentOverlap() {
        // Arrange
        Actor actor1 = new Actor(new Polar(10.0F, 0.0F), new Polar(2.0f, 45.0f));
        Actor actor2 = new Actor(new Polar(11.0f, 0.0f), new Polar(2.0f, 45.0f));
        Actor actor3 = new Actor(new Polar(20.0f, 0.0f), new Polar(2.0f, 45.0f));
        
        List<Actor> actors = new ArrayList<>();
        actors.add(actor1);
        actors.add(actor2);
        actors.add(actor3);

        // Act
        List<Actor> overlappingActors = Overlap.overlap(
                actors,
            new Polar(10.5f, 0.0f),
            new Polar(2.0f, 45.0f)
        );

        // Assert
        assertEquals(2, overlappingActors.size());
        assertTrue(overlappingActors.contains(actor1));
        assertTrue(overlappingActors.contains(actor2));
        assertFalse(overlappingActors.contains(actor3));
    }

    @Test
    void testSingleAgentOverlap() {
        // Arrange
        Polar pos1 = new Polar(10.0f, 0.0f);
        Polar width1 = new Polar(2.0f, 45.0f);
        
        Polar pos2 = new Polar(11.0f, 0.0f);
        Polar width2 = new Polar(2.0f, 45.0f);

        // Act
        boolean isOverlapping = Overlap.overlap(pos1, width1, pos2, width2);

        // Assert
        assertTrue(isOverlapping);
    }

    @Test
    void testNoOverlap() {
        // Arrange
        Polar pos1 = new Polar(10.0f, 0.0f);
        Polar width1 = new Polar(2.0f, 45.0f);
        
        Polar pos2 = new Polar(20.0f, 0.0f);
        Polar width2 = new Polar(2.0f, 45.0f);

        // Act
        boolean isOverlapping = Overlap.overlap(pos1, width1, pos2, width2);

        // Assert
        assertFalse(isOverlapping);
    }

    @Test
    void testEdgeOverlap() {
        // Arrange
        Polar pos1 = new Polar(10.0f, 0.0f);
        Polar width1 = new Polar(2.0f, 45.0f);
        
        Polar pos2 = new Polar(12.0f, 0.0f);
        Polar width2 = new Polar(2.0f, 45.0f);

        // Act
        boolean isOverlapping = Overlap.overlap(pos1, width1, pos2, width2);

        // Assert
        assertTrue(isOverlapping);
    }

    @Test
    void testAngularOverlap() {
        // Arrange
        Polar pos1 = new Polar(10.0f, 0.0f);
        Polar width1 = new Polar(2.0f, 45.0f);
        
        Polar pos2 = new Polar(10.0f, 40.0f);
        Polar width2 = new Polar(2.0f, 45.0f);

        // Act
        boolean isOverlapping = Overlap.overlap(pos1, width1, pos2, width2);

        // Assert
        assertTrue(isOverlapping);
    }
}
