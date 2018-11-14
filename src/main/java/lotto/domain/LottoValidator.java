package lotto.domain;

import java.util.List;

import static lotto.utils.Utils.LOTTO_NUMBER_BOUND_END;

public class LottoValidator {

    public static void validate(List<LottoNo> winningNumbers) {
        winningNumbers.stream()
                .filter(LottoNo::isInvalidRange)
                .forEach(no -> {
                    throw new IllegalArgumentException();
                });

        if(winningNumbers.size() > LOTTO_NUMBER_BOUND_END)
            throw new IllegalArgumentException();
    }

    public static void validate(LottoNo bonus) {
        if(bonus.isInvalidRange())
            throw new IllegalArgumentException();
    }
}
