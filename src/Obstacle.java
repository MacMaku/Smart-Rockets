import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by LenovoY500 on 9/4/2017.
 */
public class Obstacle {
    public static int x, y, w, h;

    public Obstacle(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void show(GraphicsContext gc){
        gc.setFill(Color.GRAY);
        gc.fillRect(x, y, w, h);
    }
}
