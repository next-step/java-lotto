package lotto.domain;

import java.util.Set;

public class WinningLottoNumbers {
    private final LottoNumbers luckyNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        this.luckyNumbers = luckyNumbers;
        this.bonusNumber = bonusNumber;
        if(luckyNumbers.compare(bonusNumber) > 0) {
            throw new IllegalArgumentException("보너스볼이 당첨번호와 중복됩니다.");
        }
    }

    public int matchCount(LottoNumbers lottoNumbers) {
        return lottoNumbers.matchCount(luckyNumbers);
    }

    public int compareBonus(Set<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.compareNumber(bonusNumber) > 0)
                .count();
    }
}
