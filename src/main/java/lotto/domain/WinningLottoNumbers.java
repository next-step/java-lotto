package lotto.domain;

import java.util.Set;

public class WinningLottoNumbers {
    private final LottoNumbers luckyNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        this.luckyNumbers = luckyNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(LottoNumbers lottoNumbers) {
        return lottoNumbers.matchCount(luckyNumbers);
    }

    public int containBonus(Set<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.compareNumber(bonusNumber) > 0)
                .count();
    }
}
