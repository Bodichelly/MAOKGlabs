package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab1");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);
        Rectangle plot = new Rectangle();
        Color PlotColor = Color.rgb(138, 0, 0);
        int PlotX = 50;
        int PlotY = 115;
        plot.setX(PlotX);
        plot.setY(PlotY);
        plot.setWidth(300);
        plot.setHeight(190);
        plot.setFill(PlotColor);

        Rectangle handle = new Rectangle();
        handle.setX(PlotX+45);
        handle.setY(PlotY+91);
        handle.setWidth(210);
        handle.setHeight(8);
        handle.setFill(Color.BLACK);

        Ellipse whitePart = new Ellipse();
        whitePart.setCenterX(PlotX+230);
        whitePart.setCenterY(PlotY+95);
        whitePart.setRadiusX(60);
        whitePart.setRadiusY(80);
        whitePart.setFill(Color.WHITE);

        Ellipse grayPart = new Ellipse();
        grayPart.setCenterX(PlotX+230);
        grayPart.setCenterY(PlotY+95);
        grayPart.setRadiusX(55);
        grayPart.setRadiusY(75);
        grayPart.setFill(Color.rgb(206, 206, 206));

        int RedCircleRadius = 50;

        Circle redCircleLeft = new Circle();
        redCircleLeft.setCenterX(PlotX+164);
        redCircleLeft.setCenterY(PlotY+95);
        redCircleLeft.setRadius(RedCircleRadius);
        redCircleLeft.setFill(PlotColor);



        Arc arc = new Arc();
        arc.setCenterX(PlotX+297);
        arc.setCenterY(PlotY+95);
        arc.setRadiusX(RedCircleRadius);
        arc.setRadiusY(RedCircleRadius);
        arc.setFill(PlotColor);
        arc.setStartAngle(90.0f);
        arc.setLength(180.0f);
        arc.setType(ArcType.ROUND);


        root.getChildren().add(plot);
        root.getChildren().add(whitePart);
        root.getChildren().add(grayPart);
        root.getChildren().add(redCircleLeft);
        root.getChildren().add(arc);
        root.getChildren().add(handle);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
