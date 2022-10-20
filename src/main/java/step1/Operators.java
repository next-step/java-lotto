package step1;

import java.util.Queue;

public class Operators {

    private final ExpressionAsOperators expressionAsOperators;

    public Operators(ExpressionAsOperators expressionAsOperators) {
        this.expressionAsOperators = expressionAsOperators;
    }

    public Queue<Operator> operators() {
        return expressionAsOperators.operators();
    }

}
