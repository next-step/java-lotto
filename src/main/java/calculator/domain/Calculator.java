package calculator.domain;

import calculator.common.IntegerParser;

public class Calculator {
    public int addEachAll(String[] elements, IntegerParser parser) {
        int result = 0;
        for (String element : elements) {
            int value = parser.parse(element);
            result += value;
        }
        return result;
    }
}
