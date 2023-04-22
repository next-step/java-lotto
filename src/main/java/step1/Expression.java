package step1;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final List<Node> nodes;
    private final List<Operator> operators;

    public Expression(List<String> inputArray) {
        this.nodes = extractNodes(inputArray);
        this.operators = extractOperators(inputArray);
    }

    private List<Node> extractNodes(List<String> inputList) {
        List<Node> nodes = new ArrayList<>();
        for (String inputString : inputList) {
            extractNode(nodes, inputString);
        }
        return nodes;
    }

    private void extractNode(List<Node> nodes, String token) {
        if (Node.nodeConvertible(token)) {
            nodes.add(new Node(token));
        }
    }

    private List<Operator> extractOperators(List<String> inputs) {
        List<Operator> operators = new ArrayList<>();
        for (String inputString : inputs) {
            extractOperator(operators, inputString);
        }
        return operators;
    }

    private void extractOperator(List<Operator> operators, String token) {
        if(Node.nodeConvertible(token)) {
            return;
        }
        if (Operator.operatorConvertible(token)) {
            operators.add(new Operator(token));
            return;
        }
        throw new IllegalArgumentException();
    }

    public int execute() {
        int sum = nodes.get(0).getValue();
        for (int i = 0; i < operators.size(); i++) {
            sum = operators.get(i).calculate(sum, nodes.get(i + 1).getValue());
        }
        return sum;
    }
}
