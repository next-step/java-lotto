package lotto.domain;

import lotto.exception.NotPositiveException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Money {

    private static final Pattern POSITIVE_PATTERN = Pattern.compile("^[0-9]*$");

    private final int money;

    public Money(String input) {
        checkPositive(input);
        money = Integer.parseInt(input);
    }

    private void checkPositive(String input) {
        Matcher matcher = POSITIVE_PATTERN.matcher(input);
        if (!matcher.find()) {
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
