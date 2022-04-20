package lotto.model;

import lotto.util.RandomNumberUtil;

import java.util.Set;
import java.util.stream.Collectors;

public class RandomGenerationStrategy implements NumberGenerationStrategy {

    private static final int MAX_LOTTO_NUMBER_BOUND = 45;

    private static final int LOTTO_NUMBERS_SIZE = 6;

    @Override
    public Set<LottoNumber> generateNumbers() {
        Set<Integer> numbers = RandomNumberUtil.generateNumbers(MAX_LOTTO_NUMBER_BOUND, LOTTO_NUMBERS_SIZE);
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

}
