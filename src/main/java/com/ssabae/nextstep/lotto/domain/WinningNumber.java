package com.ssabae.nextstep.lotto.domain;

import static com.ssabae.nextstep.lotto.domain.lotto.LottoConstant.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class WinningNumber {

    private final static String LOTTO_NUMBER_SIZE_NOT_EQUALS_MESSAGE = "당첨 번호는 %d개여야 합니.";
    private final static String LOTTO_NUMBER_OUT_BOUND_MESSAGE = "당첨 번호는 %d~%d 사이여야합니다..";
    public static final String NUMBER_SEPARATOR = ",";

    private final List<Integer> winningNumberList;

    public WinningNumber(String text) {
        winningNumberList = Collections.unmodifiableList(
                Arrays.stream(text.split(NUMBER_SEPARATOR))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .sorted(Comparator.comparingInt(o -> o))
                    .collect(Collectors.toList())
                );
        validate(winningNumberList);
    }

    private void validate(List<Integer> winningNumberList) {
        if (winningNumberList.size() != LOTTO_NUMBER_SIZE) {
            String message = String.format(LOTTO_NUMBER_SIZE_NOT_EQUALS_MESSAGE, LOTTO_NUMBER_SIZE);
            throw new IllegalArgumentException(message);
        }
        if (!isInBoundOfLottoNumbers(winningNumberList)) {
            String message = String.format(LOTTO_NUMBER_OUT_BOUND_MESSAGE, LOTTO_MIN_VALUE, LOTTO_MAX_VALUE);
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isInBoundOfLottoNumbers(List<Integer> winningNumberList) {
        return winningNumberList.stream()
                .allMatch(number -> LOTTO_MIN_VALUE < number && number < LOTTO_MAX_VALUE);
    }

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }
}
