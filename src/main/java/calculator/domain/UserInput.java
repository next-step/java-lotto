package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    private static final String[] DEFAULT_DELIMITER = {",",":"};
    private static final String CUSTOM_DELIMIT_START_STRING = "//";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CUSTOM_DELIMITER_LAST_INDEX = 5;
    private String input;

    public UserInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public List<Integer> getIntegers() {
        if (isCustom()) {
            String[] split = removeCustomDelimit().split(findCustomDelimiter());
            return changeToIntegers(split);
        }

        String[] split = input.split(Arrays.toString(DEFAULT_DELIMITER));
        return changeToIntegers(split);
    }

    private boolean isCustom() {
        return input.startsWith(CUSTOM_DELIMIT_START_STRING);
    }

    private String removeCustomDelimit() {
        return input.substring(CUSTOM_DELIMITER_LAST_INDEX);
    }

    private String findCustomDelimiter() {
        return String.valueOf(input.charAt(CUSTOM_DELIMITER_INDEX));
    }

    private List<Integer> changeToIntegers(String[] split) {
        return Arrays.stream(split)
                .map(Integer::new)
                .collect(Collectors.toList());
    }

}
