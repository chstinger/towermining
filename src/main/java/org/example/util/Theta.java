package org.example.util;

public class Theta {

    public static boolean compareTheta(float theta,float targetTheta) {
        if (theta==targetTheta) {
            return true;
        }
        return targetTheta - Const.compareTolerance <= theta && theta <= targetTheta + Const.compareTolerance;
    }

    public static boolean compareTheta(float theta,float targetTheta, float thetaDelta) {
        float t1=theta+thetaDelta;
        // Todo implement correctly with
        if (theta<=t1) {
            return theta<=targetTheta && targetTheta<=t1;
        } else {
            return t1<=targetTheta && targetTheta<=theta;
        }
    }

    public static float addTheta(float theta,float deltaTheta) {
        theta+=deltaTheta;
        theta = getTheta(theta);
        return theta;
    }

    private static float getTheta(float theta) {
        if (Const.startTheta<= theta && theta<= Const.endTheta) {
            return theta;
        }
        if (theta < Const.startTheta) {
            theta = Const.endTheta+ theta;
        }
        if (theta > Const.endTheta) {
            theta = theta - Const.endTheta;
        }
        return getTheta(theta);

    }
}
