package lotto.model;

import java.util.List;

public class WinningNumbers {


    private LottoNumbers numbers;
    private Number bonusNumber;

    public WinningNumbers(LottoNumbers numbers, Number bonusNumber) {
        verifyBonusDuplication(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(LottoNumbers pickNumbers) {
        long matchCount = numbers.matchCount(pickNumbers);
        return LottoRank.match((int) matchCount, hasBonus(pickNumbers));
    }

    private boolean hasBonus(LottoNumbers pickNumbers) {
        return pickNumbers.contains(bonusNumber);
    }

    private void verifyBonusDuplication(LottoNumbers numbers, Number bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("이미 번호가 뽑혀있습니다. ");
        }
    }
}
