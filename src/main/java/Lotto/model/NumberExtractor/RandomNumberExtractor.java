package Lotto.model.NumberExtractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberExtractor implements NumberExtractor {
    private final List<Integer> numberList;

    public RandomNumberExtractor(int min, int max) {
        this.numberList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numberList.add(i);
        }
    }

    @Override
    public List<Integer> extract(int size) {
        Collections.shuffle(numberList);
        return new ArrayList<>(numberList.subList(0, size));
    }
}
