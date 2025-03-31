package com.nextstep.camp.lotto;

import com.nextstep.camp.calculator.application.dto.ExpressionRequest;
import com.nextstep.camp.calculator.application.dto.ExpressionResponse;
import com.nextstep.camp.calculator.infrastructure.view.dto.ExpressionInputData;
import com.nextstep.camp.common.view.handler.LottoInputViewHandler;
import com.nextstep.camp.lotto.view.dto.LottoInputData;

public class LottoApplication {

    public static void main(String[] args) {
        LottoInputViewHandler inputViewHandler = LottoInputViewHandler.init();


        LottoInputData lottoInputData = inputViewHandler.handle();

    }
}
