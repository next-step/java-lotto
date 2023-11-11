package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGeneration implements NumberGeneration {
    private static final int LOTTO_STANDARD_NUMBER = 46;

    @Override
    public List<Integer> generate() {
        List<Integer> numList = makeNumbers();
        Collections.shuffle(numList);
        return numList.subList(0, 6);
    }

    private static List<Integer> makeNumbers() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i < LOTTO_STANDARD_NUMBER; i++) {
            numList.add(i);
        }
        return numList;
    }

}