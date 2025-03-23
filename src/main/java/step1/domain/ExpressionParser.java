package step1.domain;

import java.util.LinkedList;
import java.util.Queue;

public class ExpressionParser {

    public static Expression parse(String input) {
        String[] tokens = input.split(" ");

        Queue<Operand> operands = new LinkedList<>();
        Queue<Operator> operators = new LinkedList<>();

        for (int i = 0; i < tokens.length; i+=2) {
            operands.offer(new Operand(tokens[i]));
        }
        for (int i = 1; i < tokens.length; i+=2) {
            operators.offer(Operator.fromSymbol(tokens[i].charAt(0)));
        }

        return new Expression(operands, operators);
    }
}
