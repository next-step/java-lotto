package com.nextstep.lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> numbers, int bonusNumber) {
        this.bonusNumber = LottoNumber.of(bonusNumber);
        if (numbers.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("보너스 넘버는 당첨 번호에 포함될 수 없습니다.");
        }
        this.lotto = new Lotto(numbers);
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
