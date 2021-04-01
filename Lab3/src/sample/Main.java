package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    Paint backGroundColor = Color.rgb(120, 255, 184);

    Group root;
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene (root, 600, 500);
        scene.setFill(backGroundColor);

        root.getChildren().add(Ground.getGround());
        root.getChildren().add(Ground.getPath());
        root.getChildren().addAll(House.getHouse());
        root.getChildren().add(Tree.getTrunk());
        root.getChildren().add(Tree.getLeaves());



        int duration = 3000;

        ScaleTransition scaleFrom = new ScaleTransition(Duration.millis(duration), root);
        scaleFrom.setToX(1);
        scaleFrom.setToY(1);

        ScaleTransition scaleTo = new ScaleTransition(Duration.millis(duration), root);
        scaleTo.setToX(0.5);
        scaleTo.setToY(0.5);

        RotateTransition rotate = new RotateTransition(Duration.millis(duration), root);
        rotate.setByAngle(360f);
        rotate.setCycleCount(Timeline.INDEFINITE);

        TranslateTransition translateTo = new TranslateTransition(Duration.millis(duration * 2), root);
        translateTo.setFromX(-100);
        translateTo.setToX(150);
        translateTo.setCycleCount(Timeline.INDEFINITE);
        translateTo.setAutoReverse(true);

        TranslateTransition translateFrom = new TranslateTransition(Duration.millis(duration * 2), root);
        translateFrom.setFromX(150);
        translateFrom.setToX(-100);
        translateFrom.setCycleCount(Timeline.INDEFINITE);
        translateFrom.setAutoReverse(true);

        SequentialTransition scale = new SequentialTransition();
        scale.getChildren().addAll(
                scaleTo,
                scaleFrom
        );
        scale.setCycleCount(Timeline.INDEFINITE);

        SequentialTransition translate = new SequentialTransition();
        translate.getChildren().addAll(
                translateTo,
                translateFrom
        );
        translate.setCycleCount(Timeline.INDEFINITE);

        ParallelTransition animations = new ParallelTransition();
        animations.getChildren().addAll(
                scale,
                rotate,
                translate
        );
        animations.play();


        primaryStage.setTitle("House");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
