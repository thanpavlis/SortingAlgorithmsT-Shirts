package assignment4sorting.sortingalgorithms;

import assignment4sorting.utils.SortUtils;
import assignment4sorting.variations.TShirt;
import java.util.Comparator;
import java.util.List;

public class QuickSort {

    public QuickSort() {
    }

    public void execute(List<TShirt> tshirts, Comparator<TShirt> comparator, String sortType) {
        quickSort(tshirts, 0, tshirts.size() - 1, comparator, sortType);//klhsh tou quick sort me parametrous thn lista, to low, to high, ton comparator kai to sortType
    }

    private int partition(List<TShirt> tshirts, int low, int high, Comparator<TShirt> comparator, String sortType) {
        TShirt pivot = tshirts.get(high);//orismos pivot
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (sortType.equals("ASC")) {//ascending
                if (comparator.compare(tshirts.get(j), pivot) < 0) {
                    SortUtils.swapTShirtArrayList(tshirts, ++i, j);
                }
            } else {//descending
                if (comparator.compare(tshirts.get(j), pivot) > 0) {
                    SortUtils.swapTShirtArrayList(tshirts, ++i, j);
                }
            }
        }
        SortUtils.swapTShirtArrayList(tshirts, i + 1, high);
        return (i + 1);
    }

    private void quickSort(List<TShirt> tshirts, int low, int high, Comparator<TShirt> comparator, String sortType) {
        if (low < high) {
            int pi = partition(tshirts, low, high, comparator, sortType);
            quickSort(tshirts, low, pi - 1, comparator, sortType);
            quickSort(tshirts, pi + 1, high, comparator, sortType);
        }
    }
}
