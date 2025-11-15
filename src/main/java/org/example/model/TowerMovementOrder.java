package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.util.Theta;

/**
 * Created : 19/07/2025-14.49
 *
 * @author Claes Hougaard <cch@neoconsult.dk>
 */
@Data
@AllArgsConstructor
public class TowerMovementOrder {
    enum Type {None,Rotate,MoveToTargetAndStop,MoveToTargetAndRotate,Stop}
    Type orderType;
    float targetPosTheta;
    float changeDeltaPosTheta;
    float rotateDeltaPosTheta;

    public static TowerMovementOrder createRotate(float rotateDeltaPosTheta) {
        return new TowerMovementOrder(Type.Rotate, 0, 0, rotateDeltaPosTheta);
    }

    public float update(float theta,float delta) {
        switch (orderType) {
            case Rotate: theta += delta*rotateDeltaPosTheta; break;
            case MoveToTargetAndStop:
                if (Theta.compareTheta(theta,targetPosTheta,changeDeltaPosTheta)) {
                    orderType = Type.Stop;
                }
                theta += delta*changeDeltaPosTheta;
                break;
            case MoveToTargetAndRotate:
                if (Theta.compareTheta(theta,targetPosTheta,changeDeltaPosTheta)) {
                    orderType = Type.Rotate;
                }
                theta += delta*changeDeltaPosTheta;
                break;
        }
        return theta;
    }

}
