

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {
    public static int width = 500, height = 500;
    public static GraphicsContext gc;
    public Population population;
    public Target target;
    public Obstacle obstacle;
    public static int lifespan = 250;
    public static int count = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Smart Rockets!");
        Canvas canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();


        Group root = new Group();
        root.getChildren().add(canvas);
        animationStart();


        population = new Population();
        target = new Target();
        obstacle = new Obstacle(100, 200, 300, 50);

        Scene scn = new Scene(root, width, height);
        primaryStage.setScene(scn);
        primaryStage.show();
    }


        public void animationStart(){
            AnimationTimer timer;

            timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    gc.clearRect(0,0, width,height);
                    target.show(gc);
                    obstacle.show(gc);

                    population.run();
                    count++;
                    if(count >= lifespan){
                        population.evaluate();
                        population.selection();
                        count = 0;
                    }




                }

            };
            timer.start();
        }


    public static void main(String[] args) {
        launch(args);
    }
}
