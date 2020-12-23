package com.monds.nextstep.lotto.domain;

public final class LottoErrorMessage {

    private LottoErrorMessage() {}

    public static final String MONEY_ERROR_MESSAGE = "money must be at least zero: %s";

    public static final String MONEY_UNIT_MESSAGE = "Only %s won units are allowed: %s";

    public static final String COUNT_ERROR_MESSAGE = "Negative count are not allowed: %s";

    public static final String NOT_ENOUGH_MONEY_MESSAGE = "Not enough money";

    public static final String INVALID_INPUT_MESSAGE = "input cannot be null or empty: %s";

    public static final String LOTTO_NUMBER_SIZE_MESSAGE = "Count of Lotto numbers is less than %s";

    public static final String NUMBER_RANGE_MESSAGE = "Lotto number range %s to %s but was: %s";

    public static final String PARSING_ERROR_MESSAGE = "Input number is not parsable: %s";
}
