package study;

import study.dto.ExpressionBlock;

public class Expression {
    private final String[] values;
    private final String SPLIT_REGEX = " ";

    private Expression(String value) {
        inputValidate(value);
        String[] split = value.split(SPLIT_REGEX);
        inputArrayValidate(split.length);
        this.values = split;
    }

    public static Expression from(String value) {
        return new Expression(value);
    }

    private void inputArrayValidate(int length) {
        if (length % 2 == 0) {
            throw new IllegalArgumentException("Input string is wrong.");
        }
    }

    private void inputValidate(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("Input string is wrong.");
        }
    }

    public int first(){
        return get(0);
    }

    public ExpressionBlock getAsExpressionBlock(int index){
        if(isOdd(index)){
            return ExpressionBlock.of(Operator.from(values[index]), Integer.parseInt(values[index + 1]));
        }
        throw new IllegalArgumentException("Wrong Index");
    }

    public int size(){
        return values.length;
    }

    private int get(int index){
        return Integer.parseInt(values[index]);
    }

    private boolean isOdd(int index) {
        return index % 2 != 0;
    }
}
