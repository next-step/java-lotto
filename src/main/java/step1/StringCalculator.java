package step1;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int calculate(String input) {
        if(input==null || input.isBlank() ) {
            throw new IllegalArgumentException();
        }
        String[] inputArray = input.split(" ");
        List<Node> nodeList = new ArrayList<>();
        List<Operator> operatorList = new ArrayList<>();
        for( int i=0 ; i<inputArray.length ; i++ ) {
            String current = inputArray[i];
            if(i%2 == 0) {
                nodeList.add(new Node(current));
            }
            if(i%2 == 1) {
                operatorList.add(new Operator(current));
            }
        }
        Expression expression = new Expression(nodeList, operatorList);
        return expression.execute();

    }
}
