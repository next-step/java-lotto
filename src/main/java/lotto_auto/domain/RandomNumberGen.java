package lotto_auto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGen {
    public RandomNumberGen() {
    }

    public static List<Integer> getRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        List<Integer> numberList = getNumberList();
        Collections.shuffle(numberList);

        for (int i = 0; i < 6; i++) {
            randomNumberList.add(numberList.get(i));
        }
        Collections.sort(randomNumberList);

        return randomNumberList;
    }

    private static List<Integer> getNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numberList.add(i);
        }
        return numberList;
    }
}
