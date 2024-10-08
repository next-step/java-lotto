package calculator;

public class StringCalculator {

    public static int calculate(String inputFormular) {
        Formular formular = new Formular(inputFormular);

        int cnt = 0;
        int result = 0;
        while (formular.hasOperand()) {
            result = calculateByOperator(formular.getNextOperator(), formular.getNextOperand(),  cnt == 0 ? formular.getNextOperand() : new Operand(String.valueOf(result)));
            cnt++;
        }
        return result;
    }


    public static int calculateByOperator(Operator operator, Operand operand1, Operand operand2) {
        OperatorEnum operatorEnum = OperatorEnum.getEnumByValue(operator.getValue());
        switch (operatorEnum) {
            case MULTIPLY:
                return CalculatorEngin.multiply(operand1, operand2);
            case DIVIDE:
                return CalculatorEngin.divide(operand1, operand2);
            case ADD:
                return CalculatorEngin.add(operand1, operand2);
            case SUBTRACT:
                return CalculatorEngin.subtract(operand1, operand2);
            default:
                throw new IllegalArgumentException("연산자 오류");
        }
    }

    public static void main(String[] args) {
        int result  = StringCalculator.calculate("1 * 2 * 3 - 1 + 5");
        System.out.println(result);
    }
}

