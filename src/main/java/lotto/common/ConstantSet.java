package lotto.common;

import java.util.regex.Pattern;

public class ConstantSet {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_TICKET_PRICE = 1000;
    public static final String CUSTOM_MONEY_REGEXP = "^\\d+$";
    public static final Pattern CUSTOM_MONEY_PATTERN = Pattern.compile(CUSTOM_MONEY_REGEXP);
}
