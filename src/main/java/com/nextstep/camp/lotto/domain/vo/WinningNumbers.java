package com.nextstep.camp.lotto.domain.vo;

import java.util.List;

public class WinningNumbers {
    private final LottoNumbers numbers;

    public WinningNumbers(List<Integer> rawNumbers) {
        this.numbers = new LottoNumbers(rawNumbers);
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }
}
