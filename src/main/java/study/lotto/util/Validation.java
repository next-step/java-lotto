package study.lotto.util;

import study.lotto.domain.LottoNumber;
import study.lotto.exception.LottoException;
import study.lotto.view.InputView;

import java.util.Objects;

public class Validation {

    private Validation() { }

    public static boolean isNumeric(final String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isLackOfMoney(final String inputMoney) {
        return Integer.parseInt(inputMoney) < InputView.LOTTO_PRICE;
    }

    public static boolean isNotNullAndIsBlank(final String inputMoney) {
        return Objects.isNull(inputMoney) || inputMoney.isEmpty();
    }

    public static boolean isCanNotBuyLotto(final String input) {
        return !isNumeric(input) || isLackOfMoney(input);
    }

    public static void isValidationInputData(final boolean notNullAndIsBlank, final String guideNotFoundMoney) {
        if (notNullAndIsBlank) {
            throw new LottoException(guideNotFoundMoney);
        }
    }

    public static int parseInt(final String bonusNumber) {
        if(!isNumeric(bonusNumber)) {
            throw new LottoException(LottoNumber.GUIDE_CANNOT_PARSE_STRING_TO_INTEGER);
        }
        return Integer.parseInt(bonusNumber);
    }
}
