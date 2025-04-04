package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

public class BonusNumbersInput extends AbstractInput<WinningNumbers> {

    private BonusNumbersInput(InputStrategy<WinningNumbers> inputStrategy) {
        super(inputStrategy);
    }

    public static BonusNumbersInput create(InputStrategy<WinningNumbers> inputStrategy) {
        return new BonusNumbersInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "보너스 볼을 입력해 주세요.";
    }
}
