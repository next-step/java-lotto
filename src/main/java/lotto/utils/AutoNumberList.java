package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AutoNumList {

    public static List<Integer> makeNumList() {
        return sortNumber(getNumberList());
    }

    private static List<Integer> sortNumber(List<Integer> numberList) {
        numberList.sort(Comparator.comparing(Integer::intValue));
        return numberList;
    }

    private static List<Integer> getNumberList() {
        List<Integer> pickNumber = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            pickNumber.add(i);
        }
        Collections.shuffle(pickNumber);
        List<Integer> numberList = pickNumber.subList(0, 6);
        return numberList;
    }
    
    
}
