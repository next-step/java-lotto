package step1.domain;

import java.util.LinkedList;
import java.util.Queue;

public class ExpressionParser {

    public static final String DELIMITER = " ";

    public static Expression parse(String input) {
        String[] tokens = input.split(DELIMITER);

        Queue<Operand> operands = new LinkedList<>();
        Queue<Operator> operators = new LinkedList<>();

        for (String token : tokens) {
            processToken(token, operands, operators);
        }

        return new Expression(operands, operators);
    }

    private static void processToken(String token, Queue<Operand> operands, Queue<Operator> operators) {
        if (operands.size() == operators.size()) {
            operands.offer(new Operand(token));
            return;
        }
        operators.offer(Operator.fromSymbol(token.charAt(0)));
    }
}
