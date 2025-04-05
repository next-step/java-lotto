package com.nextstep.camp.lotto.view.strategy;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.vo.LottoNumber;
import com.nextstep.camp.lotto.domain.vo.LottoNumbers;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;
import com.nextstep.camp.lotto.view.component.BonusNumbersInput;
import com.nextstep.camp.lotto.view.component.WinningLottoNumbersInput;

public class WinningNumbersInputStrategy implements InputStrategy<WinningNumbers> {

    private WinningNumbersInputStrategy() {
    }

    public static WinningNumbersInputStrategy of() {
        return new WinningNumbersInputStrategy();
    }

    @Override
    public WinningNumbers read() {
        WinningLottoNumbersInputStrategy lottoNumbersInputStrategy = WinningLottoNumbersInputStrategy.ofSystemIn();
        WinningLottoNumbersInput lottoNumbersInput = WinningLottoNumbersInput.create(lottoNumbersInputStrategy);
        LottoNumbers numbers = lottoNumbersInput.action();

        BonusNumberInputStrategy bonusNumberInputStrategy = BonusNumberInputStrategy.ofSystemIn();
        BonusNumbersInput bonusNumbersInput = BonusNumbersInput.create(bonusNumberInputStrategy);
        LottoNumber bonusNumber = bonusNumbersInput.action();

        return WinningNumbers.of(numbers, bonusNumber);
    }
}
