package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.utils.NumberUtils;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.exception.NotNumberFormatStringException;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;

import java.util.Scanner;

public class LottoAmountInput extends AbstractInput<LottoAmount> {

    private LottoAmountInput(InputStrategy<LottoAmount> inputStrategy) {
        super(inputStrategy);
    }

    public static LottoAmountInput create(InputStrategy<LottoAmount> inputStrategy) {
        return new LottoAmountInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "구입금액을 입력해 주세요.";
    }
}
