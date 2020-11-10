package lotto.lib;

import lotto.exception.BadPriceException;

/**
 * NOTE: 현재는 MoneyValidator 와 코드가 동일하지만,
 * money 와 price 는 서로 다른 개념이므로,
 * validation 로직이 미래에 바뀔 수 있다.
 * 따라서 의도적으로 코드를 중복시켰다.
 */
public class PriceValidator {
    private PriceValidator() {}

    public static void validatePrice(int price) {
        int zero = 0;
        if (price <= zero) {
            throw BadPriceException.getInstance();
        }

    }

    public static void validatePrice(String price) {
        GeneralValidator.validateStrNum(price);
        int num = Integer.parseInt(price);
        validatePrice(num);
    }
}
