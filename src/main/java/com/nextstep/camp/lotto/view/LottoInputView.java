package com.nextstep.camp.lotto.view;

import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.LottoCount;
import com.nextstep.camp.lotto.view.component.*;
import com.nextstep.camp.lotto.view.dto.LottoInputData;
import com.nextstep.camp.lotto.view.strategy.*;

public class LottoInputView {
    private final LottoAmountInput lottoAmountInput;
    private final LottoManuelCountInput lottoManuelCountInput;
    private final WinningNumbersInput winningNumbersInput;

    private LottoTicketsInput lottoTicketsInput;


    private LottoInputView() {
        LottoAmountInput lottoAmountInput = LottoAmountInput.create(LottoAmountInputStrategy.ofSystemIn());
        WinningNumbersInput winningNumbersInput = WinningNumbersInput.create(WinningNumbersInputStrategy.of());
        LottoManuelCountInput lottoManuelCountInput = LottoManuelCountInput.create(LottoManuelCountInputStrategy.ofSystemIn());
        this.lottoAmountInput = lottoAmountInput;
        this.lottoManuelCountInput = lottoManuelCountInput;
        this.winningNumbersInput = winningNumbersInput;
    }

    public static LottoInputView publish() {
        return new LottoInputView();
    }

    public void render() {
        LottoAmount lottoAmount = this.lottoAmountInput.action();
        LottoCount lottoManuelCount = this.lottoManuelCountInput.action();

        LottoTicketsInputStrategy inputStrategy = LottoTicketsInputStrategy.of(lottoAmount, lottoManuelCount);
        this.lottoTicketsInput = LottoTicketsInput.create(inputStrategy);
        this.lottoTicketsInput.action();

        this.winningNumbersInput.action();
    }

    public LottoInputData toInputData() {
        return LottoInputData.of(lottoAmountInput.getValue(), lottoTicketsInput.getValue(), winningNumbersInput.getValue());
    }
}
