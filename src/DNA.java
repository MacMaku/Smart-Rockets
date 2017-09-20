import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LenovoY500 on 9/3/2017.
 */
public class DNA {
    ArrayList<Vector>genes;
    Random rand;

    public DNA(){
        genes = new ArrayList<Vector>();
        for(int i = 0; i < Main.lifespan+1; i++){
            Vector vr = new Vector(0, 0);
            vr.randomV();
            genes.add(vr);
        }
    }

    public DNA(ArrayList<Vector> genes){
        this.genes = genes;
    }

    public DNA crossOver(DNA partner){
        ArrayList<Vector> newGenes = new ArrayList<Vector>();
        rand = new Random();
        int mid = rand.nextInt(genes.size());
        for(int i = 0; i < Main.lifespan; i++){
            if( i > mid){
                newGenes.add(genes.get(i));
            } else{
                newGenes.add(partner.genes.get(i));
            }
        }
        return new DNA(newGenes);

    }
    public void mutation(){
        for (int i = 0; i < genes.size(); i++){
            if(Math.random() < 0.005){
                Vector vec = new Vector(0,0);
                vec.randomV();
                vec.limit(1);
                genes.set(i, vec);
            }
        }
    }

}
