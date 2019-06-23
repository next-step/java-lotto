package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class StringCalculator {
    private static final int VALUE_FOR_EMPTY_INPUT = 0;
    private static final String DEFAULT_SEPARATOR = "[,:]";
//    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern CUSTOM_SEPARATOR = compile("//(.)\n(.*)");


    public int calculate(String inputString) {

        if (isEmpty(inputString)) {
            return VALUE_FOR_EMPTY_INPUT;
        }

        Matcher m = CUSTOM_SEPARATOR.matcher(inputString);

        if(m.find()) {
            String customSeparator = m.group(1);
            String[] elements = m.group(2).split(customSeparator);
            return sumElements(elements);
        }
        return sumElements(inputString.split(DEFAULT_SEPARATOR));
    }

    private int sumElements(String[] elements) {
        return Arrays
                .stream(elements)
                .map(Integer::parseInt)
                .reduce((i1, i2) -> i1 + i2)
                .get();
    }

    private boolean isEmpty(String inputString) {
        return inputString == null || "".equals(inputString);
    }
}
