package lotto.utils.validator;

import lotto.exception.BadDividerException;

/**
 * NOTE: 현재는 MoneyValidator 와 코드가 동일하지만,
 * money 와 divider 는 서로 다른 개념이므로,
 * validation 로직이 미래에 바뀔 수 있다.
 * 따라서 의도적으로 코드를 중복시켰다.
 */
public class DividerValidator {
    private DividerValidator() {}

    public static void validateDivider(int divider) {
        int zero = 0;
        if (divider <= zero) {
            throw BadDividerException.getInstance();
        }

    }

    public static void validateDivider(String divider) {
        GeneralValidator.validateStrNum(divider);
        int num = Integer.parseInt(divider);
        validateDivider(num);
    }
}
