package src;

import java.util.*;

public class StringCalculator {

    public int calculate(String value) {
        Deque<String> chars = new LinkedList<>(Arrays.asList(value.split(" ")));

        int result = Integer.parseInt(chars.pop());

        while(!chars.isEmpty()) {
            Operator operator = Operator.valueByOperation(chars.pop());

            result = operator.operate(result, Integer.parseInt(chars.pop()));
        }

        return result;
    }
}
