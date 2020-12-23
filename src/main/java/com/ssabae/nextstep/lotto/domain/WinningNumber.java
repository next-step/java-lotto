package com.ssabae.nextstep.lotto.domain;

import static com.ssabae.nextstep.lotto.Constant.LOTTO_NUMBER_SIZE;

import com.ssabae.nextstep.lotto.domain.lotto.LottoNumber;
import com.ssabae.nextstep.lotto.domain.lotto.LottoNumberParser;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class WinningNumber {

    private final static String LOTTO_NUMBER_SIZE_NOT_EQUALS_MESSAGE = "당첨 번호는 %d개여야 합니.";

    private final List<LottoNumber> winningNumberList;
    private final LottoNumber bonesNumber;

    public WinningNumber(String text, String bonusText) {
        winningNumberList = LottoNumberParser.parse(text);
        bonesNumber = LottoNumber.of(Integer.parseInt(bonusText));
        validate(winningNumberList);
    }

    public List<LottoNumber> getWinningNumberList() {
        return winningNumberList;
    }

    public LottoNumber getBonesNumber() {
        return bonesNumber;
    }

    private void validate(List<LottoNumber> winningNumberList) {
        if (winningNumberList.size() != LOTTO_NUMBER_SIZE) {
            String message = String.format(LOTTO_NUMBER_SIZE_NOT_EQUALS_MESSAGE, LOTTO_NUMBER_SIZE);
            throw new IllegalArgumentException(message);
        }
    }

}
