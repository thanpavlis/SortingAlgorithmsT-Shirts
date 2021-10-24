package assignment4sorting.sortingalgorithms;

import assignment4sorting.utils.SortUtils;
import assignment4sorting.variations.TShirt;
import java.util.Comparator;
import java.util.List;

public class BubbleSort {

    public BubbleSort() {
    }

    public void execute(List<TShirt> tshirts, Comparator<TShirt> comparator, String sortType) {
        boolean swapped;
        int i = 0;
        while (i < tshirts.size()) {
            swapped = false;//estw oti den exw kanena swap
            for (int j = 1; j < (tshirts.size() - i); j++) {
                if (sortType.equals("ASC")) {//ascending
                    if (comparator.compare(tshirts.get(j - 1), tshirts.get(j)) > 0) {//krithrio gia ascending elegxei analoga ton comparator
                        SortUtils.swapTShirtArrayList(tshirts, j, j - 1);
                        swapped = true;//ekana swap 
                    }
                } else {//descending
                    if (comparator.compare(tshirts.get(j - 1), tshirts.get(j)) < 0) {//krithrio gia descending elegxei analoga ton comparator
                        SortUtils.swapTShirtArrayList(tshirts, j, j - 1);
                        swapped = true;//ekana swap
                    }
                }
            }
            if (!swapped) {//den exw kanei swap ara h lista mou einai sortarismenh
                break;
            }
            i++;
        }
    }
}
