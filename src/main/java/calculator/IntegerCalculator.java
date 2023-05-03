package calculator;

import calculator.converter.StringConverter;
import calculator.parser.ExpressionParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class IntegerCalculator {
    private final ExpressionParser parser;
    private final StringConverter<Integer> stringToIntegerConverter;
    private final Map<String, BiFunction<Integer,Integer,Integer>> operators;

    public IntegerCalculator(ExpressionParser parser,
                             StringConverter<Integer> stringToIntegerConverter) {
        this.parser = parser;
        this.stringToIntegerConverter = stringToIntegerConverter;
        this.operators = setOperators();
    }

    private Map<String, BiFunction<Integer, Integer,Integer>> setOperators() {
        HashMap<String, BiFunction<Integer,Integer,Integer>> opMap = new HashMap<>();

        opMap.put("+", Integer::sum);
        opMap.put("-", (a,b) -> a - b);
        opMap.put("*", (a,b) -> a * b);
        opMap.put("/", (a,b) -> a / b);

        return opMap;
    }

    public int calculate(String expressionString) {
        List<String> parts = parser.parse(expressionString);
        Integer init = stringToIntegerConverter.convert(parts.get(0));

        for(int idx = 0 ; idx < parts.size() ;idx++) {
            if(idx  % 2 != 0) {
                init = operators.get(parts.get(idx))
                        .apply(init, stringToIntegerConverter.convert(parts.get(idx + 1)));
            }
        }
        return init;
    }
}
