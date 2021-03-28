package stringAddCalculator;

import stringAddCalculator.model.Delimiter;
import stringAddCalculator.model.Numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int calculate(String input) {
        Delimiter.addDelimiter(",|:");
        String checkedParam = checkStringParam(input);
        if ("".equals(checkedParam)) {
            return 0;
        }
        Numbers numbers = new Numbers(splitParam(checkedParam));
        return numbers.getAddingResult();
    }

    private String[] splitParam(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            Delimiter.addDelimiter(customDelimiter);
            return m.group(2).split(Delimiter.getDelimiter());
        }
        return input.split(Delimiter.getDelimiter());
    }

    private String checkStringParam(String input) {
        if (input == null) {
            return "";
        }
        if (input.isEmpty()) {
            return "";
        }
        return input;
    }


}
