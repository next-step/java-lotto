package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> values;

    public Calculator(String input) {
        String[] split = input.split(",");

        List<Integer> values = new ArrayList<>();
        for (String value : split) {
            values.add(Integer.parseInt(value));
        }

        this.values = values;
    }

    public int sum2() {
        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        return sum;
    }

    public static int sum(int left, int right) {
        return left + right;
    }
}
