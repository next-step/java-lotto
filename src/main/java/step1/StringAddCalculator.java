package step1;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public int splitAndSum(String input) {
        UserInput userInput = new UserInput(input);
        if(userInput.isNullOrEmpty()) {
            return 0;
        }
//
//        BasicDelimiter basicDelimiter = BasicDelimiter.withDefaultDelimiter();
//
//        BasicDelimiter customBasicDelimiter = BasicDelimiter.customByPattern(input, pattern);
//
//        if(customBasicDelimiter.isExist()) {
//            basicDelimiter = basicDelimiter.addDelimiter(customBasicDelimiter);
//        }
//
//        String[] split = input.split(basicDelimiter.getSymbol());
//
//        return Arrays.stream(split)
//                .mapToInt(Integer::parseInt)
//                .sum();
        return 0;
    }
}
