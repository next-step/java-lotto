package com.nextstep.camp.lotto;

import com.nextstep.camp.lotto.view.handler.LottoInputViewHandler;
import com.nextstep.camp.lotto.view.dto.LottoInputData;

public class LottoApplication {

    public static void main(String[] args) {
        LottoInputViewHandler inputViewHandler = LottoInputViewHandler.init();
        LottoInputData lottoInputData = inputViewHandler.handle();

    }
}
