package StringCalculator.domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator {
    private final Deque<Operand> operands = new LinkedList<>();
    private final Deque<Operator> operators = new LinkedList<>();

    public StringCalculator(String userInput) {
        List<String> expressions = new Expression(userInput).split();
        for (int index = 0; index < expressions.size(); index++) {
            classifyExpression(index, expressions);
        }
    }

    private void classifyExpression(int index, List<String> expressions) {
        if (index % 2 == 0) {
            operands.add(new Operand(expressions.get(index)));
        }
        if (index % 2 != 0) {
            operators.add(Operator.from(expressions.get(index)));
        }
    }

    public int calculate() {
        while (!operators.isEmpty()) {
            Operator operator = operators.pop();
            int result = operator.calculate(operands.pop().getValue(), operands.pop().getValue());
            operands.push(new Operand(result));
        }
        return operands.pop().getValue();
    }
}
