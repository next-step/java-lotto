package step2.domain;

public class LottoInputValidator {
    public static final String WINNING_NUMBERS_DELIMITER = ",";

    private LottoInputValidator() {
    }

    public static void validateInputString(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("Input string must not be null or empty");
        }

        if (!inputString.contains(WINNING_NUMBERS_DELIMITER)) {
            throw new IllegalArgumentException("Input string must contain delimiter ','");
        }
    }
}
