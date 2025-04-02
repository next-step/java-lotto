package com.nextstep.camp.lotto.view.handler;


import com.nextstep.camp.lotto.view.LottoResultView;
import com.nextstep.camp.lotto.view.dto.LottoResultData;

public class LottoResultViewHandler {

    private LottoResultViewHandler() {
    }

    public static LottoResultViewHandler init() {
        return new LottoResultViewHandler();
    }

    public void handle(LottoResultData lottoResultData) {
        LottoResultView view = LottoResultView.publish(lottoResultData);
        view.render();
    }
}
