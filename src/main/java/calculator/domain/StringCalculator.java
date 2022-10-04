package calculator.domain;


import calculator.view.Input;
import calculator.view.Output;

import java.util.List;

public class StringCalculator {

    public static void calculate() {
        List<String> expression = new Input().inputExpression();
        List<Integer> operands = Parser.parseOperand(expression);
        List<String> operators = Parser.parseOperator(expression);
        int result = operands.get(0);

        for (int i = 0; i < operators.size(); i++) {
            result = Operator.from(operators.get(i)).execute(result, operands.get(i + 1));
        }

        new Output().print(result);
    }
}
