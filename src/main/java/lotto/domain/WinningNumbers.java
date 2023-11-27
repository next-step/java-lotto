package lotto.domain;

import lotto.enums.Rank;

import java.util.Optional;

public class WinningNumbers {
    private final LottoNumbers numbers;
    private final LottoNumber bonusNumber;

    // 수동 생성(당첨번호)
    public WinningNumbers(LottoNumbers numbers, LottoNumber bonusNumber) {
        this.numbers = numbers;

        if (this.numbers.isNumberMatched(bonusNumber)) {
            throw new IllegalArgumentException("보너스 넘버는 당첨번호와 다른 숫자여야합니다.");
        }

        this.bonusNumber = bonusNumber;
    }

    public Optional<Rank> findRank(LottoNumbers numbers) {
        return Rank.valueOf(this.numbers.matchedNumberCount(numbers), this.containBonusNumber(numbers));
    }

    private boolean containBonusNumber(LottoNumbers targetLottoNumbers) {
        return targetLottoNumbers.isNumberMatched(this.bonusNumber);
    }

    LottoNumber bonusNumber() {
        return this.bonusNumber;
    }

    LottoNumbers numbers() {
        return this.numbers;
    }
}
