package step1;

public class Splitter {
    private Splitter() {}

    private static final String SPLIT_REGEX = ",|:";

    public static String[] splitInput(String input) {
        if (Validator.checkCustomDelimiter(input)) {
            return splitCustomInput(input);
        }
        return input.split(SPLIT_REGEX);
    }

    private static String[] splitCustomInput(String input) {
        String delimiter = Extractor.extractCustomDelimiter(input);
        String customRegex = addDelimiter(SPLIT_REGEX, delimiter);
        input = Extractor.extractNums(input);
        return input.split(customRegex);
    }

    private static String addDelimiter(String splitRegex, String delimiter) {
        String or = "|";
        return splitRegex + or + delimiter;
    }
}
