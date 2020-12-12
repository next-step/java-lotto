package stringcalculator.domain;

import java.util.List;

public class Adder {
    public static int add(List<Integer> integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }

        return sum;
    }
}
