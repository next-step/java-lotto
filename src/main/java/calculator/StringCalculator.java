package calculator;

import java.util.List;

public class StringCalculator {
    private final String DELIMITER = " ";
    private final List<String> expression;

    public StringCalculator(String expression) {
        validation(expression);
        this.expression = List.of(split(expression));
    }

    public int calculate() {
        int curValue = getFirstNumber();

        for(int i = 1; i < this.expression.size(); i+=2) {
            curValue = getCurValue(i, curValue);
        }

        return curValue;
    }

    private int getCurValue(int operIndex, int curValue) {
        Operator operator = Operator.getOperator(this.expression.get(operIndex));

        curValue = operator.apply(curValue, StringToInt(expression.get(operIndex +1)));

        return curValue;
    }

    public List<String> value() {
        return this.expression;
    }
    private String[] split(String expression) {
        return expression.split(DELIMITER);
    }

    private int getFirstNumber() {
        return StringToInt(this.expression.getFirst());
    }
    private int StringToInt(String expression) {
        isNumberValidation(expression);

        return Integer.parseInt(expression);
    }
    private void isNumberValidation(String expression) {
        if(expression == null || expression.matches("\\d+")) {
            throw new IllegalArgumentException("숫자로 이루어져 있지 않음");
        }
    }

    private void validation(String expression) {
        if(expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("null 이거나 빈 문자열일 수 없습니다.");
        }

        if(expression.trim().isEmpty()) {
            throw new IllegalArgumentException("공백 문자열일 수 없습니다.");
        }
    }
}
