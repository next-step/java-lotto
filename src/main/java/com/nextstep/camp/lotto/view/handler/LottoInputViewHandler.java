package com.nextstep.camp.lotto.view.handler;


import com.nextstep.camp.lotto.view.LottoInputView;
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
