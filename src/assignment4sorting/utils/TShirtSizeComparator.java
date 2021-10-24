package assignment4sorting.utils;

import assignment4sorting.variations.TShirt;
import java.util.Comparator;

public class TShirtSizeComparator implements Comparator<TShirt> {

    @Override
    public int compare(TShirt o1, TShirt o2) {
        return (o1.getSize().compareTo(o2.getSize()));
    }
}
