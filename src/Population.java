import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LenovoY500 on 9/3/2017.
 */
public class Population {
    int populationSize = 100;
    ArrayList<Rocket> rockets;
    ArrayList<Rocket> matingpool;
    Rocket rt;
    public Random randomGenerator = new Random();
    public Population(){
        rockets = new ArrayList<Rocket>();
        for(int i = 0; i < populationSize; i++){
            rt = new Rocket();
            rockets.add(rt);
        }
    }

    public void evaluate(){
        double maxFit = 0;
        for(int i = 0; i < populationSize; i++) {
            rockets.get(i).calcFitness();
            if (rockets.get(i).fitness > maxFit) {
                maxFit = rockets.get(i).fitness;
            }

        }
        System.out.println(maxFit);
        for(int i = 0; i < populationSize; i++){
            rockets.get(i).fitness /= maxFit;
        }

        matingpool = new ArrayList<Rocket>();
        for(int i = 0; i < populationSize; i++){
            double n = rockets.get(i).fitness * 100;
            for(int j = 0; j < n; j++){
                matingpool.add(rockets.get(i));
            }
        }
    }

    public void selection(){
        ArrayList<Rocket> newRockets = new ArrayList<Rocket>();
        for(int i = 0; i < populationSize; i++){
            int index = randomGenerator.nextInt(matingpool.size());
            DNA parentA = matingpool.get(index).dna;
            index = randomGenerator.nextInt(matingpool.size());
            DNA parentB = matingpool.get(index).dna;
            DNA child;
            child = parentA.crossOver(parentB);
            child.mutation();
            newRockets.add(new Rocket(child));

        }
        rockets = newRockets;
    }





    public void run(){
        for(int i = 0; i < populationSize; i++){
            rockets.get(i).update();
            rockets.get(i).show(Main.gc);
        }
    }


}
