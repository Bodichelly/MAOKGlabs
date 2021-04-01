package sample;

import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

public class Ground {
    static Color groundColor = Color.rgb(81, 156, 0);
    static Paint pathColor = Color.rgb(184, 157, 0);

    static public Ellipse getGround() {
        Ellipse ground = new Ellipse();
        ground.setCenterX(300.0f);
        ground.setCenterY(250.0f);
        ground.setRadiusX(150.0f);
        ground.setRadiusY(75.0f);

        RadialGradient gradient = new RadialGradient(0,
                .1,
                450,
                300,
                150,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.YELLOW),
                new Stop(1, groundColor));

        ground.setFill(gradient);
        return ground;
    }

    static public Polygon getPath() {
        Polygon path = new Polygon(
                300.0, 250.0,
                310.0, 255.0,
                313.0, 260.0,
                310.0, 265.0,
                300.0, 280.0,
                270.0, 300.0,
                260.0, 310.0,
                250.0, 320.0,

                250.0+30, 323.0,
                260.0+30, 310.0,
                275.0+30, 300.0,
                300.0+30, 280.0,
                310.0+30, 265.0,
                313.0+30, 260.0,
                310.0+30, 255.0,
                310.0+30, 250.0,
                300.0+30, 240.0
        );
        path.setFill(pathColor);
        path.setStroke(Color.BLACK);
        path.setStrokeType(StrokeType.OUTSIDE);
        return path;
    }

}
