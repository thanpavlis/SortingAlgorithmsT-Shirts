package assignment4sorting;

import assignment4sorting.variations.TShirt;
import java.util.Arrays;
import java.util.List;

public abstract class Style {

    /*to header fitarei ta dedomena sthn consola*/
    public static String header() {
        int width[] = printWidths();
        String line;
        line = "|%1$-" + width[0] + "s|%2$-" + width[1] + "s|%3$-" + width[2] + "s|%4$-" + width[3] + "s|%5$-" + width[4] + "s|";
        return (line);
    }

    /*einai to width gia thn ektypwsh kathe sthlhs*/
    public static int[] printWidths() {
        return (new int[]{10, 10, 10, 10, 10});
    }

    /*epistrfei tis diakekommenes grammes tou pinaka analoga me ta widths*/
    public static String arrayDividers() {
        int width[] = printWidths();//ta width epistrefontai analoga me to poia klash kalese thn printWidths
        String outlines[] = new String[width.length];
        String line;
        for (int i = 0; i < outlines.length; i++) {//ftiaxnei tis paules ------- gia kathe sthlh analoga me ta widths
            char[] chars = new char[width[i]];
            Arrays.fill(chars, '-');
            outlines[i] = new String(chars);
        }
        line = String.format(header(), outlines[0], outlines[1], outlines[2], outlines[3], outlines[4]);
        return (line);
    }

    /*ektypwnei to header tou pinaka*/
    public static void printTableHeader(String choice, String algorithm, String criteria, String sortType) {
        System.out.println(Style.red("---------------------------------------------------------------------------------------------------------------------------------------------------------"));
        switch (choice) {
            case "random":
                System.out.println(Style.red("The random t-shirts for sorting are:"));
                break;
            default:
                System.out.println(Style.red("The sorted t-shirts using the " + algorithm + " algorithm as to " + criteria + " in " + sortType + " order are:"));
        }
        System.out.println(Style.red("---------------------------------------------------------------------------------------------------------------------------------------------------------"));
        System.out.println(arrayDividers());
        System.out.println(String.format(Style.header(), "Id", "Size", "Color", "Fabric", "Price"));
        System.out.println(arrayDividers());
    }

    /*ektypwnei tous dividers tou pinaka*/
    public static void printTableDividers() {
        System.out.println(arrayDividers());
    }

    /*pairnei san eisodo mia listas me tshirts kai ta ektypwnei*/
    public static void printListOfTShirts(List<TShirt> tshirts, String choice, String algorithm, String criteria, String sortType) {
        printTableHeader(choice, algorithm, criteria, sortType);
        for (TShirt tshirt : tshirts) {
            System.out.println(String.format(Style.header(), tshirt.getId(), tshirt.getSize(), tshirt.getColor(), tshirt.getFabric(), tshirt.getPrice()));
        }
        printTableDividers();
    }

    /*gia na ektypwnw red sthn consola*/
    public static String red(String s) {
        return ("\u001B[31m" + s + "\u001B[0m");
    }

    /*gia na ektypwnw green sthn cosnola */
    public static String green(String s) {
        return ("\u001B[32m" + s + "\u001B[0m");
    }
}
