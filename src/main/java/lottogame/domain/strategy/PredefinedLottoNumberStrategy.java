package lottogame.domain.strategy;

import lottogame.domain.lotto.LottoNumber;
import lottogame.domain.lotto.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PredefinedLottoNumberStrategy implements LottoStrategy {
    private final List<Integer> numbers;

    public PredefinedLottoNumberStrategy(String stringNumbers) {
        this.numbers = Arrays.stream(stringNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public LottoNumbers generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }
}
