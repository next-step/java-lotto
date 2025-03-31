package com.nextstep.camp.common.view.handler;


import com.nextstep.camp.lotto.view.LottoInputView;
import com.nextstep.camp.lotto.view.component.LottoAmountInput;
import com.nextstep.camp.lotto.view.component.WinningNumbersInput;
import com.nextstep.camp.lotto.view.dto.LottoInputData;

import java.util.Scanner;

public class LottoInputViewHandler {

    private LottoInputViewHandler() {
    }

    public static LottoInputViewHandler init() {
        return new LottoInputViewHandler();
    }

    public LottoInputData handle() {
        LottoAmountInput lottoAmountInput = LottoAmountInput.create(new Scanner(System.in));
        WinningNumbersInput winningNumbersInput = WinningNumbersInput.create(new Scanner(System.in));
        LottoInputView view = LottoInputView.publish(lottoAmountInput, winningNumbersInput);
        view.render();
        return view.toInputData();
    }
}
