package lotto.step2.domain;

import java.util.regex.Pattern;

public class Money {
    private long money;
    private static final long PRICE_PER_LOTTO = 1000;
    private static final String MESSAGE_INVALID_COST = "구매 금액은 1000원 이상이어야 합니다.";
    private final static String MESSAGE_CHECK_NUMERIC = "돈은 정수여야 합니다.";
    private final static String NUMERIC_REGEX = "^[-]?[0-9]+$";
    private final static Pattern PATTERN_NUMERIC = Pattern.compile(NUMERIC_REGEX);

    public Money(String money) {
        this(checkNumeric(money));
    }

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private static long checkNumeric(String number) {
        if (!PATTERN_NUMERIC.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_NUMERIC);
        }
        return Integer.parseInt(number);
    }

    private void validateMoney(long money) {
        if (money < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(MESSAGE_INVALID_COST);
        }
    }

    public long lottoCount() {
        return (money / PRICE_PER_LOTTO);
    }

    public void reduction(long lottoCount) {
        this.money -= lottoCount * PRICE_PER_LOTTO;
    }
}
