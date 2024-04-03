package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.common.LottoValidator;

public class WinnerNumber {

    private final List<LottoNumber> winnerNumbers;
    private final LottoNumber bonusNumber;

    public WinnerNumber(List<Integer> numbers, int bonusNumber) {
        LottoValidator.validateLottoNumber(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        this.winnerNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public int matchCount(List<LottoNumber> lottoNumbers) {
        return (int)lottoNumbers.stream()
            .filter(lottoNumber -> winnerNumbers.contains(lottoNumber))
            .count();
    }

    public LottoRank calculateRank(List<LottoNumber> lottoNumbers) {
        int matchCount = this.matchCount(lottoNumbers);
        boolean hasBonusNumber = lottoNumbers.contains(this.bonusNumber);
        return LottoRank.getLottoRank(matchCount, hasBonusNumber);
    }
}
