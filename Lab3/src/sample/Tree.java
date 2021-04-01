package sample;

import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Tree {
    static Color leavesColor = Color.rgb(67, 212, 0);
    static Paint trunkColor = Color.rgb(125, 71, 0);

    static public Rectangle getTrunk() {
        Rectangle trunk = new Rectangle();
        trunk.setX(400);
        trunk.setY(170);
        trunk.setWidth(10);
        trunk.setHeight(100);
        trunk.setFill(trunkColor);
        return trunk;
    }

    static public Ellipse getLeaves() {
        Ellipse leaves = new Ellipse();
        leaves.setCenterX(405);
        leaves.setCenterY(170);
        leaves.setRadiusX(30);
        leaves.setRadiusY(40);
        RadialGradient gradient = new RadialGradient(0,
                .1,
                380,
                180,
                70,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.GREEN),
                new Stop(1, leavesColor));

        leaves.setFill(gradient);
        return leaves;
    }
}
