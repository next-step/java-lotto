package lotto.domain;

import lotto.strategy.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(LottoGenerator lottoGenerator) {
        this.numbers = lottoGenerator.lotto();
    }

    public LottoRank matchCount(LottoWinNumbers lottoWinNumbers, BonusBall bonusBall) {
        return lottoWinNumbers.matchCount(numbers, bonusBall);
    }

    @Override
    public String toString() {
        String numbersString = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[" + numbersString + "]";
    }

}
