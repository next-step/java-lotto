package calculator.domain;

import calculator.common.IntegerParser;

public class Calculator {
    public int addEachAll(String[] elements) {
        int result = 0;
        for (String element : elements) {
            int value = IntegerParser.parse(element);
            result += value;
        }
        return result;
    }
}
