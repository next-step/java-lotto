package calculator.string.domain;

import calculator.string.utils.ExpressionValidator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator implements Calculator {
    private String expression;
    private Delimiter delimiter;

    public StringCalculator() {
        delimiter = new Delimiter();
    }

    @Override
    public void inputExpression(String expression) {
        this.expression = expression;
        if(delimiter.hasNewDelimiter(expression)){
            delimiter.updateDelimiter();
            this.expression = delimiter.extractExpression();
        }
    }

    @Override
    public int calculation() {
        List<String> operands = Arrays.asList(expression.split(delimiter.getDelimiters()));
        operands.forEach(ExpressionValidator::checkNumberValidation);

        return operands.stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}