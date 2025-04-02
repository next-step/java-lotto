package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.exception.LottoNumberOutOfRangeException;
import com.nextstep.camp.lotto.domain.exception.LottoNumbersSizeException;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinningNumbersInput extends AbstractInput<WinningNumbers> {

    private WinningNumbersInput(InputStrategy<WinningNumbers> inputStrategy) {
        super(inputStrategy);
    }

    public static WinningNumbersInput create(InputStrategy<WinningNumbers> inputStrategy) {
        return new WinningNumbersInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "\n지난 주 당첨 번호를 입력해 주세요.";
    }
}
