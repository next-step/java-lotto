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

        while (!chars.isEmpty()) {
            String symbol = chars.pop();
            int num2 = Integer.parseInt(chars.pop());
            result = Operator.byString(symbol)
                    .operate(result, num2);
        }

        return result;
    }
}
