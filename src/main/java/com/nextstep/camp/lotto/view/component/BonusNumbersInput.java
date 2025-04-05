package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.vo.LottoNumber;

public class BonusNumbersInput extends AbstractInput<LottoNumber> {

    private BonusNumbersInput(InputStrategy<LottoNumber> inputStrategy) {
        super(inputStrategy);
    }

    public static BonusNumbersInput create(InputStrategy<LottoNumber> inputStrategy) {
        return new BonusNumbersInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "보너스 볼을 입력해 주세요.";
    }
}
