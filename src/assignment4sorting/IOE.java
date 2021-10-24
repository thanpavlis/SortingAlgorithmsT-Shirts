package assignment4sorting;

import assignment4sorting.sortingalgorithms.BubbleSort;
import assignment4sorting.sortingalgorithms.BucketSort;
import assignment4sorting.sortingalgorithms.QuickSort;
import assignment4sorting.utils.TShirtChainComparator;
import assignment4sorting.utils.TShirtColorComparator;
import assignment4sorting.utils.TShirtFabricComparator;
import assignment4sorting.utils.TShirtSizeComparator;
import assignment4sorting.variations.TShirt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class IOE {

    private final Scanner scan;
    private List<TShirt> tshirts;//tha apothikeusw ta random mplouzakia gia na mou pei o xrhsths poia thelei na agorasei
    private final RandTshirtGen ranTSGen;//antikeimeno to opoio mou paragei ta tyxaia mplouzakia 

    public IOE() {
        scan = new Scanner(System.in);
        tshirts = new ArrayList<TShirt>();
        ranTSGen = RandTshirtGen.getRandTshirtGen();
    }

    public void generateANumOfRandomTShirts() {//o pelaths epilegei posa tyxaia mplouzakia na ftiaxw
        int n = readNumOfTShirts();
        for (int i = 0; i < n; i++) {//paragw n tyxaia mplouzakia symfwna me to plithos pou thelei o xrhsths
            tshirts.add(ranTSGen.getRandomTShirt());//paragw ena tyxaio mplouzaki 
        }
    }

    public int readNumOfTShirts() {//diabazei to plithos gia ta tyxaia mplouzakia kai to epistrefei  
        String in;
        int n;
        do {
            System.out.println("-----------------------------------------");
            System.out.println("How many random T-Sirts to make ?");
            System.out.println("-----------------------------------------");
            in = scan.nextLine();
            n = isNumber(in);
        } while (n <= 0);
        return (n);
    }

    private int isNumber(String in) {//elegxei an dothike arithmos san input
        int num;
        try {
            num = Integer.parseInt(in);
            return (num);
        } catch (NumberFormatException e) {
            return (-1);
        }
    }

    private int selectAlgorithm() {
        String in;
        int n;
        do {
            System.out.println(Style.red("---------------------------------------------------------------------------------------------------------------------------------------------------------"));
            System.out.println(Style.red("SELECT AN ALGORITHM:"));
            System.out.println("1-Quick Sort");
            System.out.println("2-Bubble Sort");
            System.out.println("3-Bucket Sort");
            System.out.print("Give Choice:");
            in = scan.nextLine();
            n = isNumber(in);
        } while ((n <= 0) || (n > 3));
        return (n);
    }

    private int selectCriteria() {
        String in;
        int n;
        do {
            System.out.println(Style.red("---------------------------------------------------------------------------------------------------------------------------------------------------------"));
            System.out.println(Style.red("AVAILABLE CHOICES FOR SORTING IN ALPHABETICAL ORDER:"));
            System.out.println("1-Size in ascending");
            System.out.println("2-Size in descending");
            System.out.println("3-Color in ascending");
            System.out.println("4-Color in descending");
            System.out.println("5-Fabric in ascending");
            System.out.println("6-Fabric in descending");
            System.out.println("7-Size and Color and Fabric in ascending");
            System.out.println("8-Size and Color and Fabric in descending");
            System.out.print("Give Choice:");
            in = scan.nextLine();
            n = isNumber(in);
        } while ((n <= 0) || (n > 8));
        return (n);
    }

    public void sortChoices() {
        //sort by Size, Color, Fabric
        int algorithm = selectAlgorithm();
        int criteria = selectCriteria();
        Style.printListOfTShirts(tshirts, "random", "", "", "");//ektypwnw ta tyxaia mplouzakia
        List<Object> al = getCriteriaInputs(criteria);
        switch (algorithm) {
            case 1: //klhsh tou Quick Sort kai ektypwsh sortarismenhs listas
                new QuickSort().execute(tshirts, (Comparator<TShirt>) al.get(0), (String) al.get(1));
                Style.printListOfTShirts(tshirts, "", "Quick Sort", (String) al.get(2), (String) al.get(1));
                break;
            case 2://klhsh tou Bubble Sort kai ektypwsh sortarismenhs listas
                new BubbleSort().execute(tshirts, (Comparator<TShirt>) al.get(0), (String) al.get(1));
                Style.printListOfTShirts(tshirts, "", "Bubble Sort", (String) al.get(2), (String) al.get(1));
                break;
            default://klhsh tou Bucket Sort kai ektypwsh sortarismenhs listas
                if ((Comparator<TShirt>) al.get(0) instanceof TShirtSizeComparator) {
                    new BucketSort().sortTShirtList(tshirts, TShirtSizeComparator.class, (String) al.get(1));
                } else if ((Comparator<TShirt>) al.get(0) instanceof TShirtColorComparator) {
                    new BucketSort().sortTShirtList(tshirts, TShirtColorComparator.class, (String) al.get(1));
                } else if ((Comparator<TShirt>) al.get(0) instanceof TShirtFabricComparator) {
                    new BucketSort().sortTShirtList(tshirts, TShirtFabricComparator.class, (String) al.get(1));
                } else {
                    new BucketSort().sortTShirtList(tshirts, TShirtChainComparator.class, (String) al.get(1));
                }
                Style.printListOfTShirts(tshirts, "", "Bucket Sort", (String) al.get(2), (String) al.get(1));
                break;
        }
    }

    private List<Object> getCriteriaInputs(int criteria) {
        List<Object> al = new ArrayList<>();
        switch (criteria) {
            case 1://size in ascending
                al.add(new TShirtSizeComparator());
                al.add("ASC");
                al.add("Size");
                break;
            case 2://size in descending
                al.add(new TShirtSizeComparator());
                al.add("DESC");
                al.add("Size");
                break;
            case 3://color in ascending
                al.add(new TShirtColorComparator());
                al.add("ASC");
                al.add("Color");
                break;
            case 4://color in descending
                al.add(new TShirtColorComparator());
                al.add("DESC");
                al.add("Color");
                break;
            case 5://fabric in ascending
                al.add(new TShirtFabricComparator());
                al.add("ASC");
                al.add("Fabric");
                break;
            case 6://fabric in ascending
                al.add(new TShirtFabricComparator());
                al.add("DESC");
                al.add("Fabric");
                break;
            case 7://size,color and fabric in ascending
                al.add(new TShirtChainComparator());
                al.add("ASC");
                al.add("Size, Color, Fabric");
                break;
            default://8=>size,color and fabric in descending
                al.add(new TShirtChainComparator());
                al.add("DESC");
                al.add("Size, Color, Fabric");
        }
        return (al);
    }

}
