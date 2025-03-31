package com.nextstep.camp.lotto.view;

import com.nextstep.camp.calculator.infrastructure.view.component.ExpressionInput;
import com.nextstep.camp.calculator.infrastructure.view.dto.ExpressionInputData;
import com.nextstep.camp.lotto.view.component.LottoAmountInput;
import com.nextstep.camp.lotto.view.component.WinningNumbersInput;
import com.nextstep.camp.lotto.view.dto.LottoInputData;

public class LottoInputView {
    private final LottoAmountInput lottoAmountInput;
    private final WinningNumbersInput winningNumbersInput;

    private LottoInputView(LottoAmountInput lottoAmountInput, WinningNumbersInput winningNumbersInput) {
        this.lottoAmountInput = lottoAmountInput;
        this.winningNumbersInput = winningNumbersInput;
    }

    public static LottoInputView publish(LottoAmountInput lottoAmountInput, WinningNumbersInput winningNumbersInput) {
        return new LottoInputView(lottoAmountInput, winningNumbersInput);
    }

    public void render() {
        lottoAmountInput.action();
        winningNumbersInput.action();
    }

    public LottoInputData toInputData() {
        return LottoInputData.of(lottoAmountInput.getValue(), winningNumbersInput.getValue());
    }
}
