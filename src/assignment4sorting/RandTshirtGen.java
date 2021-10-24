package assignment4sorting;

import assignment4sorting.variations.Color;
import assignment4sorting.variations.Fabric;
import assignment4sorting.variations.Size;
import assignment4sorting.variations.TShirt;
import java.util.Random;

public class RandTshirtGen {//dhmiourgei random TShirts, wste na zhtame oso to dynaton ligotera apo ton xrhsth kai einai singleton

    private static RandTshirtGen rtg;
    private Random rand;

    private RandTshirtGen() {//arxikopoihsh tou random antikeimenou
        rand = new Random();
    }

    public static RandTshirtGen getRandTshirtGen() {
        if (rtg == null) {//an einai null to dhmiourgei
            rtg = new RandTshirtGen();
        }
        return (rtg);
    }

    private String getRandomColor() {//random xrwma
        return (Color.values()[rand.nextInt(Color.values().length)]).toString();
    }

    private String getRandomSize() {//random megethos
        return (Size.values()[rand.nextInt(Size.values().length)]).toString();
    }

    private String getRandomFabric() {//random yliko
        return (Fabric.values()[rand.nextInt(Fabric.values().length)]).toString();
    }

    public TShirt getRandomTShirt() {//paragei ena tyxaio tshirt kai to epistrefei 
        return (new TShirt(getRandomColor(), getRandomSize(), getRandomFabric()));
    }

}
