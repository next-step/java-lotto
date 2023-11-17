package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGeneration implements NumberGeneration {
    public static final int LOTTO_MAX_NUMBER = 46;
    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> numberList = makeNumbers();
        Collections.shuffle(numberList);

        return numberList.subList(FROM_INDEX, TO_INDEX);
    }

    private List<Integer> makeNumbers() {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 1; i < LOTTO_MAX_NUMBER; i++) {
            numberList.add(i);
        }

        return numberList;
    }
}
