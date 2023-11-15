package calculator.domain;

public class Calculator {

    public Integer calculation(String[] text) {
        Operator operator = new Operator();
        Seperator seperator = new Seperator();
        Integer result = Integer.parseInt(text[0]);

        for (int i = 1; i <= Math.floor((double) text.length / 2); i++) {
            seperator.isOperator(text[2 * i - 1]); //연산자가 '+,-,*,/' 연산이 아닐 경우 IllegalArgumentException 발생
            result = operator.operation(text[2 * i - 1], String.valueOf(result), text[2 * i]);
        }

        return result;
    }
}
