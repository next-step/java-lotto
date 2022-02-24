package stringcalculator.domain;

import static stringcalculator.util.Constant.CUSTOM_DELIMITER;
import static stringcalculator.util.Constant.DEFAULT_DELIMITER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private final List<String> delimiters;

    public Delimiter() {
        this.delimiters = new ArrayList<>(Arrays.asList(DEFAULT_DELIMITER));
    }

    public List<OperandNumber> findOperands(final String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            addCustomDelimiter(matcher.group(1));
            return extractNumberFromExpression(matcher.group(2));
        }
        return extractNumberFromExpression(input);
    }

    private void addCustomDelimiter(String delimiter) {
        this.delimiters.add(delimiter);
    }

    public List<OperandNumber> extractNumberFromExpression(String input) {
        return convertOperandType(
            Arrays.asList(input.replace(" ", "").split(String.join("|", delimiters))));
    }

    private List<OperandNumber> convertOperandType(List<String> tokens) {
        List<OperandNumber> numbers = new ArrayList<>();
        tokens.forEach(
            token -> numbers.add(new OperandNumber(token))
        );
        return numbers;
    }

}
