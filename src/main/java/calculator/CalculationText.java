package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculationText {

    private static String delimeter = ",|:";
    private static final String delimeterDividor = "|";
    private static Pattern calculatorMatcher = Pattern.compile("//(.)\n(.*)");

    public String[] divide(String text) {
        if (validate(text)) {
            return new String[]{"0"};
        }
        return execute(text);
    }

    private boolean validate(String calculationText) {
        return calculationText == null || calculationText.isEmpty() || calculationText.isBlank();
    }

    private static String[] execute(String calculationText) {
        Matcher m = calculatorMatcher.matcher(calculationText);
        if (m.find()) {
            delimeter += delimeterDividor + m.group(1);
            return  m.group(2).split(delimeter);
        }
        return calculationText.split(delimeter);
    }



}
