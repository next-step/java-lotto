package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberStrategy implements NumberStrategy {

    private static final int START = 1;
    private static final int END = 31;
    private static final int MIN_IDX = 0;
    private static final int CNT = 6;

    @Override
    public List<Integer> getNumbers() {
        return shuffleNumbers(setList());
    }

    private List<Integer> shuffleNumbers(List<Integer> list) {
        Collections.shuffle(list);
        return list.subList(MIN_IDX, CNT);
    }

    private List<Integer> setList() {
        List<Integer> list = new ArrayList<>();
        for (int i = START; i < END; i++) {
            list.add(i);
        }
        return list;
    }
}
