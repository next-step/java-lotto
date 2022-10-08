import java.util.LinkedList;
import java.util.Queue;

public class StringCalculator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private static Queue<String> operations = new LinkedList<>();
    private static Queue<Integer> integers = new LinkedList<>();

    public static int splitAndCalculate(String s) {
        String[] values = splitString(s);

        for (int i = 0 ; i < values.length ; i++) {
            if (i % 2 == 0) {
                integers.add(Integer.parseInt(values[i]));
            } else {
                operations.add(values[i]);
            }
        }

        int result = calculator(integers.poll(), integers.poll(), operations.poll());
        return result;
    }

    public static int calculator(int a, int b, String value) {
        int result = 0;

        if (value.equals(PLUS)) {
            result =  a + b;
        }

        if (value.equals(MINUS)) {
            result =  a - b;
        }

        if (value.equals(MULTIPLY)) {
            result =  a * b;
        }

        if (value.equals(DIVIDE)) {
            result =  a / b;
        }

        if (!operations.isEmpty()) {
            return calculator(result, integers.poll(), operations.poll());
        }

        return result;
    }

    public static String[] splitString(String s) {
        return s.split(" ");
    }


}
