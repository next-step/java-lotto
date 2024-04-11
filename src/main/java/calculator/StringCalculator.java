package calculator;

import calculator.calc.Calculator;
import calculator.parse.ExpressionParser;

public class StringCalculator {

    private ExpressionParser parser = new ExpressionParser();
    private Calculator calculator = new Calculator();

    public StringCalculator(String originExpression){
        this.parser.parse(originExpression);
    }

    public int calculate(){

        int result = 0;
        String[] exp = this.parser.next();
        do {
            int tempResult = this.calculator.calculate(exp);
            result = tempResult;
            this.parser.setFirstOperand(result);
            exp = this.parser.next();
        } while(exp != null);

        return result;
    }
}
