package calculator;

import calculator.calc.Calculator;
import calculator.parse.ExpressionParser;

public class StringCalculator {

    private ExpressionParser parser = new ExpressionParser();
    private Calculator calculator = new Calculator();

    public StringCalculator(String originExpression){
        this.parser.parse(originExpression);
    }

    public int calc(){

        int result = 0;
        String[] exp = this.parser.next();
        do {
            int tempResult = this.calculator.calc(exp);
            result = tempResult;
            this.parser.setA(result);
            exp = this.parser.next();
        } while(exp != null);

        return result;
    }
}
