package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoNumberList {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int START_UNIT = 0;
    private static final int END_UNIT = 6;

    public static List<Integer> makeNumberList() {
        return sortNumber(getNumberList());
    }

    private static List<Integer> sortNumber(List<Integer> numberList) {
        List<Integer> sortNumber = numberList.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        return sortNumber;
    }

    private static List<Integer> getNumberList() {
        List<Integer> pickNumber = new ArrayList<>();

        for (int i = START_LOTTO_NUMBER; i < END_LOTTO_NUMBER; i++) {
            pickNumber.add(i);
        }
        Collections.shuffle(pickNumber);
        List<Integer> numberList = pickNumber.subList(START_UNIT, END_UNIT);

        return numberList;
    }

}
