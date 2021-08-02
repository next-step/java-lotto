package StringCalculator.domain;

import StringCalculator.util.StringUtils;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationInputs {

    private static final String CUSTOM_DELIMITER_INPUT_PATTERN = "\\//(.)\n(.*)";

    private final Operands operands;
    private final OperateStrategy strategy;


    public OperationInputs(String userInput, OperateStrategy strategy) {

        this.strategy = strategy;
        this.operands = prepareOperands(userInput);
    }

    private Operands prepareOperands(String userInput) {

        if (hasCustomDelimiterString(userInput)) {
            Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_INPUT_PATTERN).matcher(userInput);
            matcher.find();
            String customDelimiter = matcher.group(1);
            String operandString = matcher.group(2);

            return Operands.createByCustomDelimiter(operandString, customDelimiter);
        }

        return Operands.createByDefaultDelimiter(userInput);

    }

    private boolean hasCustomDelimiterString(String userInput) {

        if (StringUtils.checkNullOrEmpty(userInput)) {
            return false;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_INPUT_PATTERN).matcher(userInput);
        return matcher.find();
    }

    public List<Integer> getOperandsList() {
        return operands.value();
    }

    public OperateStrategy getStrategy() {
        return strategy;
    }
}
