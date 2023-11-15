package calculator.model;

import java.util.List;

public class Expression {

    public static List<String> split(String expression) {
        return List.of(expression.trim().split("\\s+"));
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

}
