package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OperatorParser {
    private static final Map<Character, Boolean> OPERATORS = Map.of(
            '+', true,
            '-', true,
            '*', true,
            '/', true
    );
    public List<String> parse(String input) {
        List<String> operators = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (isOperator(input.charAt(i))) {
                operators.add(String.valueOf(input.charAt(i)));
            }
        }
        return operators;
    }

    private boolean isOperator(char ch) {
        return OPERATORS.getOrDefault(ch, false);
    }
}
