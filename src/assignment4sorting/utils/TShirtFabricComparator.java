package assignment4sorting.utils;

import assignment4sorting.variations.TShirt;
import java.util.Comparator;

public class TShirtFabricComparator implements Comparator<TShirt> {

    @Override
    public int compare(TShirt o1, TShirt o2) {
        return (o1.getFabric().compareTo(o2.getFabric()));
    }

}
