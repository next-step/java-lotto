package com.ssabae.nextstep.lotto.domain;

import static com.ssabae.nextstep.lotto.Constant.LOTTO_MAX_VALUE;
import static com.ssabae.nextstep.lotto.Constant.LOTTO_MIN_VALUE;
import static com.ssabae.nextstep.lotto.Constant.LOTTO_NUMBER_SIZE;

import com.ssabae.nextstep.lotto.domain.lotto.LottoNumber;
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
    public static final String NUMBER_SEPARATOR = ",";

    private final List<LottoNumber> winningNumberList;
    private final LottoNumber bonesNumber;

    public WinningNumber(String text, String bonusText) {
        winningNumberList = Collections.unmodifiableList(
                Arrays.stream(text.split(NUMBER_SEPARATOR))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .sorted(Comparator.comparingInt(o -> o))
                    .map(LottoNumber::of)
                    .collect(Collectors.toList())
                );

        bonesNumber = LottoNumber.of(Integer.parseInt(bonusText));
        validate(winningNumberList);
    }

    public List<LottoNumber> getWinningNumberList() {
        return winningNumberList;
    }

    private void validate(List<LottoNumber> winningNumberList) {
        if (winningNumberList.size() != LOTTO_NUMBER_SIZE) {
            String message = String.format(LOTTO_NUMBER_SIZE_NOT_EQUALS_MESSAGE, LOTTO_NUMBER_SIZE);
            throw new IllegalArgumentException(message);
        }
    }

}
