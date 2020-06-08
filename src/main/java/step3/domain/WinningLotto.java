package step3.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningLotto {

    public static Lotto winningNumberLotto;

    public WinningLotto(String winningNumber, String bonusNumber) {

        String[] winningNumberArray = winningNumber.split(LottoGame.FIXED_DELIMITER);

        if (winningNumberArray.length != Lotto.LOTTO_DRAW_LIMIT) {
            throw new IllegalArgumentException("Not matched with draw limits. ");
        }

        Number.checkNotNumber(winningNumberArray);
        Number.checkNumber(winningNumberArray);

        Number.checkNotNumber(bonusNumber);
        Number.checkNumber(bonusNumber);

        int bonusNumberInt = Integer.valueOf(bonusNumber);

        if (bonusNumberInt > Lotto.LOTTO_DRAW_BASE_NUMBER && bonusNumberInt > Lotto.LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException("Not matched range of bonus ball.");
        }

        winningNumberLotto = new Lotto(Arrays.stream(winningNumberArray)
                .map(Integer::parseInt)
                .collect(Collectors.toSet()), bonusNumberInt);
    }

}
