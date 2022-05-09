package lotto.domain.strategy;

import lotto.domain.LottoNumber;
import lotto.util.NumberGenerateUtil;

import java.util.Set;
import java.util.stream.Collectors;

public class RandomGenerateStrategy implements LottoNumberGenerateStrategy {

    private static final int MAX_LOTTO_NUMBER_BOUND = 45;

    private static final int LOTTO_NUMBERS_SIZE = 6;

    @Override
    public Set<LottoNumber> generateLottoNumbers() {
        return this.generateNumbers().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private Set<Integer> generateNumbers() {
        return NumberGenerateUtil.generateNumbers(MAX_LOTTO_NUMBER_BOUND, LOTTO_NUMBERS_SIZE);
    }
}
