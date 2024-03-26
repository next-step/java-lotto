package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.common.LottoValidator;

public class WinnerNumber {

    private final List<LottoNumber> winnerNumbers;

    public WinnerNumber(List<Integer> numbers) {
        LottoValidator.validateLottoNumber(numbers);
        this.winnerNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public int matchCount(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
            .filter(lottoNumber -> winnerNumbers.contains(lottoNumber))
            .mapToInt(value -> 1)
            .sum();
    }
}
