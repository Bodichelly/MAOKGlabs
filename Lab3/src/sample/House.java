package sample;

import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

public class House {
    static Color houseDarkSideColor = Color.rgb(252, 251, 225);
    static Color houseBrightSideColor = Color.rgb(230, 228, 202);

    static Color houseRoofDarkSideColor = Color.rgb(219, 131, 252);
    static Color houseRoofBrightSideColor = Color.rgb(241, 204, 255);

    static Color houseDoorColor = Color.rgb(89, 37, 0);
    static Color houseWindowColor = Color.rgb(255, 247, 23);
    static double [] cornerPoint = {280.0, 260.0};

    static public Polygon[] getHouse() {
        Polygon [] house  = {
                getHouseDarkSide(),
                getHouseBrightSide(),
                getHouseDoor(),
                getHouseWindow(),
                getHouseBrightRoofSide(),
                getHouseDarkRoofSide()
        };
        return house;
    }

    static public Polygon getHouseDarkSide() {
        Polygon wall = new Polygon(
                cornerPoint[0], cornerPoint[1],
                cornerPoint[0]+70, cornerPoint[1]-30,
                cornerPoint[0]+70, cornerPoint[1]-110,
                cornerPoint[0], cornerPoint[1]-80
        );
        wall.setFill(houseDarkSideColor);
        wall.setStroke(Color.BLACK);
        wall.setStrokeType(StrokeType.OUTSIDE);
        return wall;
    }

    static public Polygon getHouseBrightSide() {
        Polygon wall = new Polygon(
                cornerPoint[0], cornerPoint[1],
                cornerPoint[0]-60, cornerPoint[1]-30,
                cornerPoint[0]-60, cornerPoint[1]-110,
                cornerPoint[0], cornerPoint[1]-80
        );
        wall.setFill(houseBrightSideColor);
        wall.setStroke(Color.BLACK);
        wall.setStrokeType(StrokeType.OUTSIDE);
        return wall;
    }

    static public Polygon getHouseDoor() {
        Polygon door = new Polygon(
                cornerPoint[0]+20, cornerPoint[1]-10,
                cornerPoint[0]+50, cornerPoint[1]-23,
                cornerPoint[0]+50, cornerPoint[1]-83,
                cornerPoint[0]+20, cornerPoint[1]-70
        );
        door.setFill(houseDoorColor);
        door.setStroke(Color.BLACK);
        door.setStrokeType(StrokeType.OUTSIDE);
        return door;
    }

    static public Polygon getHouseWindow() {
        Polygon window = new Polygon(
                cornerPoint[0]-15, cornerPoint[1]-25,
                cornerPoint[0]-45, cornerPoint[1]-40,
                cornerPoint[0]-45, cornerPoint[1]-85+10,
                cornerPoint[0]-15, cornerPoint[1]-70+10
        );
        window.setFill(houseWindowColor);
        window.setStroke(Color.BLACK);
        window.setStrokeType(StrokeType.OUTSIDE);
        return window;
    }

    static public Polygon getHouseBrightRoofSide() {
        Polygon window = new Polygon(
                cornerPoint[0]-5, cornerPoint[1]-70,
                cornerPoint[0]+80, cornerPoint[1]-105,
                cornerPoint[0], cornerPoint[1]-170

        );
        window.setFill(houseRoofBrightSideColor);
        window.setStroke(Color.BLACK);
        window.setStrokeType(StrokeType.OUTSIDE);
        return window;
    }

    static public Polygon getHouseDarkRoofSide() {
        Polygon window = new Polygon(
                cornerPoint[0]-5, cornerPoint[1]-70,
                cornerPoint[0], cornerPoint[1]-170,
                cornerPoint[0]-70, cornerPoint[1]-102
        );
        window.setFill(houseRoofDarkSideColor);
        window.setStroke(Color.BLACK);
        window.setStrokeType(StrokeType.OUTSIDE);
        return window;
    }
}
