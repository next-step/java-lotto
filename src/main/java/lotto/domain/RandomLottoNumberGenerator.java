package lotto.domain;

import java.util.*;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private List<Integer> numbers;

    public RandomLottoNumberGenerator() {
        numbers = new ArrayList<>();
        for (int i = LottoRule.min(); i <= LottoRule.max(); i++) {
            numbers.add(i);
        }
    }

    @Override
    public LottoGame numbers() {
        Collections.shuffle(numbers, new Random());
        return new LottoGame(new ArrayList<>(numbers.subList(0, LottoRule.countOfSelection())));
    }
}