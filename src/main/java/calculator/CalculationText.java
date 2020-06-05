package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculationText {

    private static String delimeter = ",|:";
    private static final String delimeterDividor = "|";
    private static Pattern calculatorMatcher = Pattern.compile("//(.)\n(.*)");
    private static String[] DEFAULT_VALUE = { "0" };
    private String[] calculationText;

    public CalculationText(String calculationText){
        this.calculationText = (validate(calculationText))
                                ? DEFAULT_VALUE
                                : divideByDelimeter(calculationText);
    }

    public String[] getDivideString() {
        return this.calculationText;
    }

    private boolean validate(String calculationText) {
        return calculationText == null || calculationText.isEmpty() || calculationText.isBlank();
    }

    private String[] divideByDelimeter(String calculationText) {
        Matcher m = calculatorMatcher.matcher(calculationText);
        if (m.find()) {
            delimeter += delimeterDividor + m.group(1);
            return  m.group(2).split(delimeter);
        }
        return calculationText.split(delimeter);
    }



}
