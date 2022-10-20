package step1;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {

    public static List<Pair<Operator, Integer>> tokenize(String input) {
        List<Pair<Operator, Integer>> result = new ArrayList<>();

        String[] split = input.split(" ");
        result.add(classify("+", split[0]));
        for (int i = 1; i < split.length; i += 2) {
            result.add(classify(split[i], split[i + 1]));
        }

        return result;
    }

    private static Pair<Operator, Integer> classify(String op, String num) {
        return new Pair<>(Operator.of(op.charAt(0)), Integer.parseInt(num));
    }
}
