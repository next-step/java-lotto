package step1;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final List<Node> nodes;
    private final List<Operator> operators;

    public Expression(List<Node> nodes, List<Operator> operators) {
        this.nodes = nodes;
        this.operators = operators;
    }

    public static List<Node> extractNodes(List<String> inputList) {
        List<Node> nodes = new ArrayList<>();
        for (String inputString : inputList) {
            extractNode(nodes, inputString);
        }
        return nodes;
    }

    private static void extractNode(List<Node> nodes, String token) {
        if(Node.nodeConvertible(token)) {
            nodes.add(new Node(token));
        }
    }

    public static List<Operator> extractOperators(List<String> inputs) {
        List<Operator> operators = new ArrayList<>();
        for (String inputString : inputs) {
            extractOperator(operators, inputString);
        }
        return operators;
    }

    private static void extractOperator(List<Operator> operators, String token) {
        if (Operator.operatorConvertible(token)) {
            operators.add(new Operator(token));
        }
    }

    public int execute() {
        int sum = nodes.get(0).getValue();
        for (int i = 0; i < operators.size(); i++) {
            sum = operators.get(i).calculate(sum, nodes.get(i + 1).getValue());
        }
        return sum;
    }
}
