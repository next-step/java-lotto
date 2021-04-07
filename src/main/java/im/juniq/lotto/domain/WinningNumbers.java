package im.juniq.lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final LottoNumber bonusNumber;
    private final LottoNumbers lottoNumbers;

    public WinningNumbers(LottoNumbers numbers, LottoNumber bonusNumber) {
        this.lottoNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(LottoNumbers numbers, LottoNumber bonusNumber) {
        if (numbers.contain(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 중복 될 수 없습니다.");
        }

        return new WinningNumbers(numbers, bonusNumber);
    }

    public static WinningNumbers of(List<Integer> numbers, int bonusNumber) {
        return of(LottoNumbers.of(numbers), LottoNumber.of(bonusNumber));
    }

    public int matchedCount(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.matchedCount(lottoNumbers);
    }

    public boolean matchedBonusNumber(LottoNumbers lottoNumbers) {
        return lottoNumbers.contain(bonusNumber);
    }
}
