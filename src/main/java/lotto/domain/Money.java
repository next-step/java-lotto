package lotto.domain;

import lotto.exception.NotPositiveException;
import org.apache.commons.lang3.StringUtils;

public class Money {

    private static int money;

    public Money(String input) {
        checkNull(input);
        checkNotPositive(input);
        money = Integer.parseInt(input);
    }

    private void checkNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new NotPositiveException();
        }
    }

    private static void checkNotPositive(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new NotPositiveException();
        }
        if (Integer.parseInt(input) < 0) {
            throw new NotPositiveException();
        }
    }

    public int divideMoney(int referenceValue) {
        return money / referenceValue;
    }

    public double getMoney() {
        return money;
    }
}
