package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoNumber;

public class BonusNumberInputView {
    private final int value;

    public BonusNumberInputView(final int value) {
        this.value = value;
    }

    public LottoNumber parseToBonusNumber() {
        return new LottoNumber(this.value);
    }
}
