package firststep;

public class InputView {

    private static final String CUSTOM_BEGIN = "//";
    private static final String CUSTOM_END = "\n";
    private static final String DEFAULT_DELIMITER = ":|,";

    public String[] process(String input) {
        if (isBlank(input)) {
            return new String[] {"0"};
        }

        if (isCustomDelimiter(input)) {
            return splitByCustomDelimiter(input);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private boolean isBlank(String input) {
        return input == null || input == "";
    }

    private String[] splitByCustomDelimiter(String input) {
        String customDelimiter = input.substring(CUSTOM_BEGIN.length(), input.indexOf(CUSTOM_END));
        return input.split(CUSTOM_END)[1].split(customDelimiter);
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_BEGIN);
    }

}
