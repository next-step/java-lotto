package edu.nextstep.lotto.step2.domain;

import edu.nextstep.lotto.common.BusinessException;
import edu.nextstep.lotto.step2.error.LottoError;
import edu.nextstep.lotto.step2.vo.WinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningList {

    private static final String DEFAULT_PATTERN = "[,]";
    private final List<WinningNumber> winningNumberList;

    public WinningList(String text) {
        winningNumberList = Arrays.stream(text.split(DEFAULT_PATTERN))
                .map(WinningNumber::new)
                .collect(Collectors.toList());

        if (winningNumberList.size() != 6) {
            throw new BusinessException(LottoError.INVALID_VALUE_WRONG_WINNING_NUMBER_COUNT);
        }
    }

    public List<WinningNumber> getWinningNumberList() {
        return winningNumberList;
    }
}
