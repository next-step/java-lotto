package com.nextstep.camp.lotto.domain.vo;

import java.util.List;

public class WinningNumbers {
    private final LottoNumbers numbers;
    private LottoNumber bonusNumber;

    private WinningNumbers(List<Integer> rawNumbers) {
        this.numbers = LottoNumbers.of(rawNumbers);
    }

    public static WinningNumbers of(List<Integer> rawNumbers) {
        return new WinningNumbers(rawNumbers);
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public WinningNumbers withBonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
        return this;
    }
}
