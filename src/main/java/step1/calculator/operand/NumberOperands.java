package step1.calculator.operand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberOperands {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int NULL_OR_EMPTY_OPERAND = 0;
    private static final int DELIMITER_GROUP_NUMBER = 1;
    private static final int OPERANDS_GROUP_NUMBER = 2;

    private List<NumberOperand> operands = new ArrayList<>();

    private NumberOperands() {
    }

    private NumberOperands(int operand) {
        NumberOperand numberOperand = NumberOperand.from(operand);
        operands.add(numberOperand);
    }

    public static NumberOperands from(String string) {
        if (string == null || string.isEmpty()) {
            return new NumberOperands(NULL_OR_EMPTY_OPERAND);
        }

        NumberOperands numberOperands = new NumberOperands();
        String[] stringList = toArray(string);
        numberOperands.operands = Arrays.stream(stringList)
                .map(NumberOperand::from)
                .collect(Collectors.toList());

        return numberOperands;
    }

    private static String[] toArray(String string) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(string);
        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_GROUP_NUMBER);
            String operandsString = m.group(OPERANDS_GROUP_NUMBER);
            return operandsString.split(customDelimiter);
        }

        return string.split(DEFAULT_DELIMITER_REGEX);
    }

    public List<NumberOperand> getOperands() {
        return Collections.unmodifiableList(operands);
    }
}
