package com.nextstep.lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("numbers cannot conatins bonus number");
        }
        this.lotto = new Lotto(numbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public long getMatchedCount(List<LottoNumber> collectedNumbers) {
        return collectedNumbers.stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    public boolean checkBonusNumber(List<LottoNumber> numbers) {
        return numbers.contains(bonusNumber);
    }
}
