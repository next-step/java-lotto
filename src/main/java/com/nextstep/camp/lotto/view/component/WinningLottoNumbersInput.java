package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.vo.LottoNumbers;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

public class WinningLottoNumbersInput extends AbstractInput<LottoNumbers> {

    private WinningNumbers winningNumbers;

    private WinningLottoNumbersInput(InputStrategy<LottoNumbers> inputStrategy) {
        super(inputStrategy);
    }

    public static WinningLottoNumbersInput create(InputStrategy<LottoNumbers> inputStrategy) {
        return new WinningLottoNumbersInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "\n지난 주 당첨 번호를 입력해 주세요.";
    }
}
