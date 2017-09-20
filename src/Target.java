import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by LenovoY500 on 9/3/2017.
 */
public class Target {
    public static Vector pos;
    public int size = 50;

    public Target(){
        pos = new Vector(230, 100);

    }

    public void show(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillOval(pos.x, pos.y, size, size);
        gc.setFill(Color.YELLOW);
        gc.fillOval(pos.x+5, pos.y+5, size-10, size-10);

    }
}
