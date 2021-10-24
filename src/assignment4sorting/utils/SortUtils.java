package assignment4sorting.utils;

import assignment4sorting.variations.TShirt;
import java.util.List;

public abstract class SortUtils {

    public static void swapTShirtArrayList(List<TShirt> tshirt, int i, int j) {//auth h methodos kanei to swap
        TShirt buffer;
        buffer = tshirt.get(j);
        tshirt.set(j, tshirt.get(i));
        tshirt.set(i, buffer);
    }
}
