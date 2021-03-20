package lotto.domain;

import java.util.*;

public class RandomLottoNumber implements LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private List<Integer> numbers;

    public RandomLottoNumber() {
        numbers = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++) {
            numbers.add(i);
        }
    }

    @Override
    public int min() {
        return MIN;
    }

    @Override
    public int max() {
        return MAX;
    }

    @Override
    public List<Integer> numbers() {
        Collections.shuffle(numbers, new Random());
        return new ArrayList<>(numbers.subList(0, 6));
    }
}