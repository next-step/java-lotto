package step1.calculator.operand;

import step1.calculator.config.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberOperands {

    private static final String DEFAULT_DELIMITER_REGEX = Config.DEFAULT_DELIMITER_REGEX;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(Config.CUSTOM_DELIMITER_REGEX);

    private List<NumberOperand> operands = new ArrayList<>();

    private NumberOperands() {}

    private NumberOperands(int operand) {
        NumberOperand numberOperand = NumberOperand.from(operand);
        operands.add(numberOperand);
    }

    public static NumberOperands from(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return new NumberOperands(0);
        }

        NumberOperands numberOperands = new NumberOperands();
        String[] stringList = splitToArr(inputString);
        numberOperands.operands = Arrays.stream(stringList)
                .map(NumberOperand::from)
                .collect(Collectors.toList());

        return numberOperands;
    }

    private static String[] splitToArr(String inputString) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return inputString.split(DEFAULT_DELIMITER_REGEX);
    }

    public List<NumberOperand> getOperands() {
        return Collections.unmodifiableList(operands);
    }
}
