package com.nextstep.lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("numbers cannot conatins bonus number");
        }
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public boolean checkBonusNumber(List<LottoNumber> numbers) {
        return numbers.contains(bonusNumber);
    }
}
