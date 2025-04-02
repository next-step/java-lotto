package com.nextstep.camp.lotto.view;

import com.nextstep.camp.lotto.domain.strategy.LottoAutoPickStrategy;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.view.component.LottoAmountInput;
import com.nextstep.camp.lotto.view.component.LottoTicketsInput;
import com.nextstep.camp.lotto.view.component.WinningNumbersInput;
import com.nextstep.camp.lotto.view.dto.LottoInputData;
import com.nextstep.camp.lotto.view.strategy.*;

public class LottoInputView {
    private final LottoAmountInput lottoAmountInput;
    private final WinningNumbersInput winningNumbersInput;

    private LottoTicketsInput lottoTicketsInput;


    private LottoInputView() {
        LottoAmountInput lottoAmountInput = LottoAmountInput.create(LottoAmountInputStrategy.ofSystemIn());
        WinningNumbersInput winningNumbersInput = WinningNumbersInput.create(WinningNumbersInputStrategy.ofSystemIn());
        this.lottoAmountInput = lottoAmountInput;
        this.winningNumbersInput = winningNumbersInput;
    }

    public static LottoInputView publish() {
        return new LottoInputView();
    }

    public void render() {
        LottoAmount lottoAmount = this.lottoAmountInput.action();

        LottoAutoPickStrategy pickStrategy = LottoAutoPickStrategy.of(lottoAmount);
        LottoTicketsInputStrategy inputStrategy = LottoTicketsInputStrategy.of(pickStrategy);
        this.lottoTicketsInput = LottoTicketsInput.create(inputStrategy);
        this.lottoTicketsInput.action();

        this.winningNumbersInput.action();
    }

    public LottoInputData toInputData() {
        return LottoInputData.of(lottoAmountInput.getValue(), lottoTicketsInput.getValue(), winningNumbersInput.getValue());
    }
}
