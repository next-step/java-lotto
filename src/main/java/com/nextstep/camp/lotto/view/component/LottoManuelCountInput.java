package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.vo.LottoCount;

public class LottoManuelCountInput extends AbstractInput<LottoCount> {

    private LottoManuelCountInput(InputStrategy<LottoCount> inputStrategy) {
        super(inputStrategy);
    }

    public static LottoManuelCountInput create(InputStrategy<LottoCount> inputStrategy) {
        return new LottoManuelCountInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "\n수동으로 구매할 로또 수를 입력해 주세요.";
    }
}
