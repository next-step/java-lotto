package step01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static step01.Config.*;

public class Numbers {

    private List<String> numbers = new ArrayList<>();

    public Numbers(String value) {
        checkRegex(value);
    }

    private void checkRegex(String value) {
        Matcher m = Pattern.compile(REGEX).matcher(value);
        if (m.find()) {
            String customDelimiter = m.group(FIRST);
            Arrays.stream(m.group(SECOND).split(customDelimiter)).forEach(this::splitString);
            return;
        }
        splitString(value);
    }

    private void splitString(String value) {
        String[] numberSplit = value.split(BASIC_SEPARATOR);
        numbers.addAll(Arrays.asList(numberSplit));
    }

    public String sum() {
        if (Validation.isNumberZeroOrEmpty(numbers)) {
            return ZERO;
        }
        Validation.checkIsNegative(numbers);
        return String.valueOf(numbers.stream().mapToInt(Integer::parseInt).reduce(0, Integer::sum));
    }


}
