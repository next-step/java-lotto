package im.juniq.lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final LottoNumber bonusNumber;
    private final LottoNumbers lottoNumbers;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this(LottoNumbers.of(numbers), new LottoNumber(bonusNumber));
    }

    public WinningNumbers(LottoNumbers numbers, LottoNumber bonusNumber) {
        this.lottoNumbers = numbers;
        if (lottoNumbers.contain(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 중복 될 수 없습니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public int matchedCount(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.matchedCount(lottoNumbers);
    }

    public boolean matchedBonusNumber(LottoNumbers lottoNumbers) {
        return lottoNumbers.contain(bonusNumber);
    }
}
