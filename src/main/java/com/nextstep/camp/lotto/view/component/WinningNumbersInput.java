package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

public class WinningNumbersInput extends AbstractInput<WinningNumbers> {

    private WinningNumbers winningNumbers;

    private WinningNumbersInput(InputStrategy<WinningNumbers> inputStrategy) {
        super(inputStrategy);
    }

    public static WinningNumbersInput create(InputStrategy<WinningNumbers> inputStrategy) {
        return new WinningNumbersInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "";
    }
}
