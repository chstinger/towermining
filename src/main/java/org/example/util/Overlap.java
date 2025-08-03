package org.example.util;

import org.example.api.ActionCallback;
import org.example.model.Actor;
import org.example.model.Cone;
import org.example.model.Polar;

import java.util.ArrayList;
import java.util.List;

public class Overlap {


    public static void overlapConeActor(List<Cone> cones, List<Actor> actors, ActionCallback<Actor> actionCallback) {
        for (Cone cone : cones) {
            List<Actor> overlap = Overlap.overlap(actors, cone.getPos(), cone.getWidth());
            for (Actor actor : overlap) {
                actionCallback.action(actor);
            }
        }
    }


    public static List<Actor> overlap(List<Actor> actors, Polar pos, Polar width) {
        ArrayList<Actor> res = new ArrayList<>();
        for (Actor actor : actors) {
            if (overlap(actor.getPos(), actor.getWidth(), pos, width)) {
                res.add(actor);
            }
        }
        return res;
    }


    public static boolean overlap(Polar pos, Polar pos1) {
        if (pos.getTheta()== pos1.getTheta()) {
            return pos.getR() - Const.compareTolerance < pos1.getR() && pos1.getR() < pos.getR() + Const.compareTolerance;
        }
        return false;
    }


    public static boolean overlap(Polar pos, Polar width, Polar pos1, Polar width1) {
        // Tjek for overlap i vinkel (theta)
        boolean overlapTheta = (pos.getTheta() - width.getTheta() <= pos1.getTheta() + width1.getTheta()) &&
                (pos1.getTheta() - width1.getTheta() <= pos.getTheta() + width.getTheta());

        if (!overlapTheta) {
            return false;
        }
        // Tjek for overlap i radius (R)
        boolean overlapR = (pos.getR() - width.getR() <= pos1.getR() + width1.getR()) &&
                (pos1.getR() - width1.getR() <= pos.getR() + width.getR());


        return overlapR;
    }

}
