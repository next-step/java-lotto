package calculator.calc;

public class Calculator {

    public int calculate(String[] addExpression){
        String firstOperandString = addExpression[0];
        String opString = addExpression[1];
        String secondOperandString = addExpression[2];

        int a = Integer.parseInt(firstOperandString);
        int b = Integer.parseInt(secondOperandString);

        return Operator.of(opString).apply(a, b);
    }
}
