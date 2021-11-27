import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    private final static String DEFAULT_DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private final String[] parsedInput;

    public Input(String... parsedInput) {
        /* Test */
        this.parsedInput = parsedInput;
    }

    public Input(String input) {
        this.parsedInput = createParsedInput(input);
    }

    private String[] createParsedInput(String input) {
        if (isEmpty(input)) {
            return new String[] { input };
        }

        Matcher delimiterMatcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        String numberPart = input;
        String delimiter = DEFAULT_DELIMITER;

        if (delimiterMatcher.find()) {
            delimiter = delimiterMatcher.group(1);
            numberPart = delimiterMatcher.group(2);
        }

        return numberPart.split(delimiter);
    }

    private boolean isEmpty(String input) {
        return input == null ||
                input.trim().isEmpty();
    }

    public String[] getParsedInput() {
        return parsedInput;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Input input = (Input) o;
        return Arrays.equals(parsedInput, input.parsedInput);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(parsedInput);
    }
}
