import javafx.scene.canvas.GraphicsContext;

import static java.lang.Math.random;

/**
 * Created by LenovoY500 on 9/3/2017.
 */
public class Rocket {
    Vector pos;
    Vector vel;
    Vector acc;
    DNA dna;
    int size = 10;
    double fitness = 0;
    boolean completed = false;
    boolean crashed = false;

    public Rocket(){
        double randomX = random();
        if(random() > 0.5){
            randomX = -randomX;
        }
        double randomY = random();
        pos = new Vector(Main.width/2 - 5, Main.height - 10);
        vel = new Vector(randomX, randomY);
        acc = new Vector(0, 0);
        dna = new DNA();
    }

    public Rocket(DNA dna){
        double randomX = random();
        if(random() > 0.5){
            randomX = -randomX;
        }
        double randomY = random();
        pos = new Vector(Main.width/2 - 5, Main.height - 10);
        vel = new Vector(randomX, randomY);
        acc = new Vector(0, 0);
        this.dna = dna;
    }

    public void show(GraphicsContext gc){
        gc.setFill(javafx.scene.paint.Color.BLACK);
        gc.fillOval(pos.x, pos.y, size, size);
    }

    public void applyForce(Vector force){
        acc.add(force);

    }

    public void update(){

        if(Vector.dist(pos.x, Target.pos.x+25, pos.y, Target.pos.y+25)  < 25){
            completed = true;
        }
        if(pos.x > Obstacle.x && pos.x < Obstacle.x + Obstacle.w && pos.y > Obstacle.y && pos.y < Obstacle.y + Obstacle.h ){
            crashed = true;
        }
        if(pos.x < 0 || pos.x > Main.width-5 || pos.y > Main.height || pos.y < 0){
            crashed = true;
        }
        if(!completed && !crashed) {
            this.applyForce(this.dna.genes.get(Main.count));
            vel.add(acc);
            vel.inverseSign();
            pos.add(vel);
            vel.inverseSign();
            acc.mult(0);
            vel.limit(3);
        }
    }

    public void calcFitness(){
        double d = Vector.dist(pos.x, Target.pos.x, pos.y, Target.pos.y);
        d = 1/d;
        if(completed){
            d *= 10;
        }
        if(crashed){
            d/=10;
        }

        fitness = d;
    }
}


