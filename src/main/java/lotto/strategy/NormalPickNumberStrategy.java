package lotto.strategy;

import java.util.*;

public class NormalPickNumberStrategy implements PickNumberStrategy{

    private final static int RANGE_START = 1;
    private final static int RANGE_END = 45;
    private final List<Integer> numberRange = new ArrayList<>();

    public NormalPickNumberStrategy() {
        for (int num = RANGE_START ; num <= RANGE_END ; num++ ) {
            numberRange.add(num);
        }
    }

    @Override
    public Set<Integer> getNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 6) {
            Collections.shuffle(numberRange);
            numbers.add(numberRange.get(0));
        }

        return numbers;
    }
}
