package org.example;

import org.example.util.Theta;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ThetaTest {

    @Test
    void testAdd() {
        assertEquals(200,Theta.addTheta(100,100));
        assertEquals(40,Theta.addTheta(100,300));
        assertEquals(40,Theta.addTheta(100,660));
        assertEquals(60,Theta.addTheta(100,-40));
        assertEquals(320,Theta.addTheta(100,-140));
        assertEquals(320,Theta.addTheta(100,-500));
    }
}
