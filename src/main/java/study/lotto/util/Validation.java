package study.lotto.util;

import study.lotto.exception.LottoException;

import java.util.Objects;

import static study.lotto.util.Constants.*;

public class Validation {

    private Validation() { }

    public static boolean isNotNullAndIsBlank(final String inputMoney) {
        return Objects.isNull(inputMoney) || inputMoney.isEmpty();
    }

    public static int parseInt(final String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new LottoException(GUIDE_ERR_NOT_USE_VALUE);
        }
    }
}
