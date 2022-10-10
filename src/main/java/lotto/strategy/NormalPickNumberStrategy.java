package lotto.strategy;

import java.util.*;

public class NormalPickNumberStrategy implements PickNumberStrategy{

    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private final List<Integer> numberRange = new ArrayList<>();

    public NormalPickNumberStrategy() {
        for (int num = RANGE_START ; num <= RANGE_END ; num++ ) {
            numberRange.add(num);
        }
    }

    @Override
    public List<Integer> getNumbers() {
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < 6) {
            Collections.shuffle(numberRange);
            numberSet.add(numberRange.get(0));
        }

        List<Integer> numbers = new ArrayList<>(numberSet);
        Collections.sort(numbers);
        return numbers;
    }
}
