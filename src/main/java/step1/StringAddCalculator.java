package step1;

import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {
    private static final int CUSTOM_DELIMITER_BEGIN_INDEX = 2;
    private static final int CUSTOM_DELIMITER_LENGTH = 1;

    private static final int INPUT_BEGIN_INDEX_WITH_CUSTOM_DELIMITER = 4;

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CRLF = "\n";

    public int add(final String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return addInternal(input);
    }

    private boolean isNullOrEmpty(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    private int addInternal(final String input) {
        if (hasCustomDelimiter(input)) {
            final String customDelimiter = parseCustomDelimiter(input);
            final String formattedInput = parseInputAfterCustomDelimiter(input);
            return addInternal(formattedInput, customDelimiter);
        }
        return addInternal(input, DEFAULT_DELIMITER);
    }

    private boolean hasCustomDelimiter(final String input) {
        return input.contains(CRLF);
    }

    private String parseCustomDelimiter(final String input) {
        return input.substring(CUSTOM_DELIMITER_BEGIN_INDEX, CUSTOM_DELIMITER_BEGIN_INDEX + CUSTOM_DELIMITER_LENGTH);
    }

    private String parseInputAfterCustomDelimiter(final String input) {
        return input.substring(INPUT_BEGIN_INDEX_WITH_CUSTOM_DELIMITER);
    }

    private int addInternal(final String input, final String delimiter) {
        return Arrays.stream(input.split(delimiter))
                     .map(Integer::parseInt)
                     .peek(this::ensurePositive)
                     .mapToInt(Integer::intValue)
                     .sum();
    }

    private void ensurePositive(final int input) {
        if (input < 0) {
            throw new IllegalArgumentException();
        }
    }
}
