package lotto.domain;

import java.util.*;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private final LottoRule lottoRule;
    private List<Integer> numbers;

    public RandomLottoNumberGenerator(LottoRule rule) {
        numbers = new ArrayList<>();
        this.lottoRule = rule;
        for (int i = lottoRule.min(); i <= lottoRule.max(); i++) {
            numbers.add(i);
        }
    }

    @Override
    public LottoNumber numbers() {
        Collections.shuffle(numbers, new Random());
        return new LottoNumber(new ArrayList<>(numbers.subList(0, lottoRule.countOfSelection())), lottoRule);
    }
}