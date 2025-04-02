package com.nextstep.camp.lotto.view.handler;


import com.nextstep.camp.lotto.domain.strategy.LottoAutoPickStrategy;
import com.nextstep.camp.lotto.view.strategy.LottoAmountInputStrategy;
import com.nextstep.camp.lotto.view.strategy.LottoTicketsInputStrategy;
import com.nextstep.camp.lotto.view.strategy.WinningNumbersInputStrategy;
import com.nextstep.camp.lotto.view.LottoInputView;
import com.nextstep.camp.lotto.view.component.LottoAmountInput;
import com.nextstep.camp.lotto.view.component.LottoTicketsInput;
import com.nextstep.camp.lotto.view.component.WinningNumbersInput;
import com.nextstep.camp.lotto.view.dto.LottoInputData;

public class LottoInputViewHandler {

    private LottoInputViewHandler() {
    }

    public static LottoInputViewHandler init() {
        return new LottoInputViewHandler();
    }

    public LottoInputData handle() {
        LottoInputView view = LottoInputView.publish();
        view.render();
        return view.toInputData();
    }
}
