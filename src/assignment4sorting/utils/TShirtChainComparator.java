package assignment4sorting.utils;

import assignment4sorting.variations.TShirt;
import java.util.Comparator;

public class TShirtChainComparator implements Comparator<TShirt> {

    @Override
    public int compare(TShirt o1, TShirt o2) {//filtrarisma Size, Color kai Fabric se seira
        if (o1.getSize().compareTo(o2.getSize()) > 0) {//filtrarisma ws pros Size
            return (1);
        } else if (o1.getSize().compareTo(o2.getSize()) == 0) {//an exoun to idio Size
            if (o1.getColor().compareTo(o2.getColor()) > 0) {//fltrarisma ws pros Color
                return (1);
            } else if (o1.getColor().compareTo(o2.getColor()) == 0) {//an exoun idio Color
                if (o1.getFabric().compareTo(o2.getFabric()) > 0) {//filtrarisma ws pros to teleutaio krithrio pou einai to Fabric
                    return (1);
                } else {
                    return (-1);
                }
            } else {
                return (-1);
            }
        } else {
            return (-1);
        }
    }
}
