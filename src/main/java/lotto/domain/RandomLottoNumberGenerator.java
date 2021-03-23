package lotto.domain;

import java.util.*;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private List<Integer> numbers;

    public RandomLottoNumberGenerator() {
        numbers = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++) {
            numbers.add(i);
        }
    }

    @Override
    public LottoNumber numbers() {
        Collections.shuffle(numbers, new Random());
        return new LottoNumber(new ArrayList<>(numbers.subList(0, 6)));
    }
}