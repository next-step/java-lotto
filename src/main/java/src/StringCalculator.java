package src;

import java.util.*;

public class StringCalculator {

    private final Splitter splitter;

    public StringCalculator(Splitter splitter) {
        this.splitter = splitter;
    }

    public int calculate(String value) {
        Deque<String> chars = splitter.split(value);
        int result = Integer.parseInt(chars.pop());

        while(!chars.isEmpty()) {
            result = Operator.byString(chars.pop())
                    .operate(result, Integer.parseInt(chars.pop()));
        }

        return result;
    }
}
