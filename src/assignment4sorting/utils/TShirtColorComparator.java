package assignment4sorting.utils;

import assignment4sorting.variations.TShirt;
import java.util.Comparator;

public class TShirtColorComparator implements Comparator<TShirt> {

    @Override
    public int compare(TShirt o1, TShirt o2) {
        return (o1.getColor().compareTo(o2.getColor()));
    }

}
