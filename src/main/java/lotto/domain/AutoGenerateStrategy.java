package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoGenerateStrategy implements GenerateNumStrategy {
    private final List<Integer> selectableNums;

    AutoGenerateStrategy(int maxNum) {
        List<Integer> numList = new ArrayList<>(maxNum);

        for (int i = 0; i < maxNum; i++) {
            numList.add(i);
        }

        selectableNums = numList;
    }

    public List<Integer> generate() {
        Collections.shuffle(selectableNums);

        return selectableNums;
    }
}
