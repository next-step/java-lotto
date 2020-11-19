package lotto.validator;

import lotto.utils.MessageUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_WINNING_SIZE = 6;
    private static final int LOTTO_WINNING_MAXIMUM_NUM = 45;
    private static final String EMPTY_VALUE = "";
    private static final String REGEX_DELIMITER_DEFAULT = ",";

    private InputValidator() {
        throw new IllegalStateException(MessageUtils.UTILITY_CLASS);
    }

    public static void validateBuyLotto(String amount) {
        validateParseInt(amount);

        int num = Integer.parseInt(amount);
        validateMoreThanZero(num);
        validateMultiple1000(num);
    }

    public static void validateParseInt(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (Exception e) {
            throw new IllegalArgumentException(MessageUtils.INPUT_MUST_NUMBER);
        }
    }

    public static void validateMoreThanZero(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(MessageUtils.INPUT_MORE_THAN_ZERO);
        }
    }

    public static void validateMultiple1000(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MessageUtils.INPUT_MULTIPLE_1000);
        }
    }

    public static void validateWinning(String winning) {
        validateNotEmpty(winning);

        String[] winningsNum = winning.split(REGEX_DELIMITER_DEFAULT);
        validateSize(winningsNum);
        validateOverMaxNum(winningsNum);
    }

    public static void validateNotEmpty(String winning) {
        if (Objects.isNull(winning) || winning.equals(EMPTY_VALUE)) {
            throw new IllegalArgumentException(MessageUtils.INPUT_NOT_EMPTY);
        }
    }

    public static void validateSize(String[] winning) {
        int size = Arrays.stream(winning).collect(Collectors.toSet()).size();
        if (size != LOTTO_WINNING_SIZE) {
            throw new IllegalArgumentException(MessageUtils.INPUT_WINNING_SIZE);
        }
    }

    public static void validateOverMaxNum(String[] winning) {
        Arrays.stream(winning)
                .map(Integer::parseInt)
                .filter(num -> num > LOTTO_WINNING_MAXIMUM_NUM)
                .findAny()
                .ifPresent(v -> {
                    throw new IllegalArgumentException(MessageUtils.INPUT_WINNING_MAXIMUM_NUM);
                });
    }
}
