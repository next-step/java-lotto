package exception;

import java.util.Map;
import java.util.stream.IntStream;

public class ValueException {

    private static Map<String, Boolean> operandsMap = Map.of(
            "+", true,
            "-", true,
            "*", true,
            "/", true
    );


    public static void checkAllOperands(String[] input) {
        IntStream.iterate(1, i -> i < input.length, i -> i + 2).mapToObj(i -> input[i]).forEach(ValueException::checkOperand);
    }

    public static boolean checkOperand(String input) {
        if (operandsMap.containsKey(input)) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
