package assignment4sorting.sortingalgorithms;

import assignment4sorting.utils.TShirtChainComparator;
import assignment4sorting.utils.TShirtColorComparator;
import assignment4sorting.utils.TShirtSizeComparator;
import assignment4sorting.variations.Color;
import assignment4sorting.variations.Fabric;
import assignment4sorting.variations.Size;
import assignment4sorting.variations.TShirt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BucketSort {

    private HashMap<String, List<TShirt>> buckets;//to key einai to krithrio sortarismatos kathe fora, kai h arraylist perixei ta tshirts pou epalitheuoun to krithrio auto
    private List<String> sortedSizes, sortedColors, sortedFabrics;//me bash autes tis listes xanadhmiourgeitai h arxikh 

    public BucketSort() {//arxikopoish lista twn buckets
        buckets = new HashMap<String, List<TShirt>>();
    }

    public void sortTShirtList(List<TShirt> tshirts, Class c, String sortType) {
        createBuckets(c);
        sortCriteria(sortType, c);
        initializeBuckets(tshirts, c);
        if (c == TShirtChainComparator.class) {//gia na kanei ton chain sorting se kathe bucket xwrista
            sortEveryBucketUsingQuickSort(sortType);
        }
        mergeSortedList(tshirts, c);
    }

    private void sortEveryBucketUsingQuickSort(String sortType) {
        QuickSort qs = new QuickSort();
        TShirtChainComparator tcc = new TShirtChainComparator();
        for (int j = 0; j < sortedSizes.size(); j++) {//o QuickSort xrhsimopoieitai gia na filtrarei kathe bucket xwrista xrhsimopoiwntas ton chain Comparator
            qs.execute(buckets.get(sortedSizes.get(j)), tcc, sortType);
        }
    }

    private void mergeSortedList(List<TShirt> tshirts, Class c) {//kanei merge ola ta buckets me seira analoga to krithrio
        tshirts.clear();//adeiasma listas
        if (c == TShirtSizeComparator.class || c == TShirtChainComparator.class) {
            for (int j = 0; j < sortedSizes.size(); j++) {//h lista sortedSizes periexei ta sizes sortarismena analoga
                tshirts.addAll(buckets.get(sortedSizes.get(j)));//prospelaunw kathe bucket se sort seira, analoga to key kai giauto to bucket prosthetw thn lista pou periexei sthn arxiki mou
            }
        } else if (c == TShirtColorComparator.class) {
            for (int j = 0; j < sortedColors.size(); j++) {
                tshirts.addAll(buckets.get(sortedColors.get(j)));
            }
        } else {//TShirtFabricComparator
            for (int j = 0; j < sortedFabrics.size(); j++) {
                tshirts.addAll(buckets.get(sortedFabrics.get(j)));
            }
        }
    }

    private void sortCriteria(String sortType, Class c) {
        if (c == TShirtSizeComparator.class || c == TShirtChainComparator.class) {//eite gia chain eite gia Size sortarw ta Sizes to thewrw kyrio krithrio
            sortedSizes = Stream.of(Size.values()).map(Enum::name).collect(Collectors.toList());
            if (sortType.equals("ASC")) {//ascending
                Collections.sort(sortedSizes);
            } else {//descending
                Collections.sort(sortedSizes, Collections.reverseOrder());
            }
        } else if (c == TShirtColorComparator.class) {
            sortedColors = Stream.of(Color.values()).map(Enum::name).collect(Collectors.toList());
            if (sortType.equals("ASC")) {//ascending
                Collections.sort(sortedColors);
            } else {//descending
                Collections.sort(sortedColors, Collections.reverseOrder());
            }
        } else {//TShirtFabricComparator
            sortedFabrics = Stream.of(Fabric.values()).map(Enum::name).collect(Collectors.toList());
            if (sortType.equals("ASC")) {//ascending
                Collections.sort(sortedFabrics);
            } else {//descending
                Collections.sort(sortedFabrics, Collections.reverseOrder());
            }
        }
    }

    private void createBuckets(Class c) {
        if (c == TShirtSizeComparator.class || c == TShirtChainComparator.class) {//kai stis dio periptwseis ftiaxnw ton idio arithmo apo buckets simfwna me tis times tou Size
            for (Size value : Size.values()) {//kathe bucket perixei mia lista sthn opoia apothikeuw TShirts
                buckets.put(value.toString(), new ArrayList<TShirt>());
            }
        } else if (c == TShirtColorComparator.class) {
            for (Color value : Color.values()) {
                buckets.put(value.toString(), new ArrayList<TShirt>());
            }
        } else {//TShirtFabricComparator
            for (Fabric value : Fabric.values()) {
                buckets.put(value.toString(), new ArrayList<TShirt>());
            }
        }
    }

    private void initializeBuckets(List<TShirt> tshirts, Class c) {
        if (c == TShirtSizeComparator.class || c == TShirtChainComparator.class) {//eite gia chain eite gia Size h arxikopoihsh einai h idia
            for (TShirt tshirt : tshirts) {//kathe tshirt paei sto antistoixo bucket analoga me to krithrio pou thelw na to sortarw
                buckets.get(tshirt.getSize()).add(tshirt);
            }
        } else if (c == TShirtColorComparator.class) {
            for (TShirt tshirt : tshirts) {
                buckets.get(tshirt.getColor()).add(tshirt);
            }
        } else {//TShirtFabricComparator
            for (TShirt tshirt : tshirts) {
                buckets.get(tshirt.getFabric()).add(tshirt);
            }
        }
    }

}
