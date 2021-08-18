package calculator;

import java.util.List;

public class StringCalculator {

    public static int sum(String stringNumbers) {
        List<Integer> numbers = Numbers.toListOfInt(stringNumbers);
        int result = 0;

        for (int i : numbers) {
            result += i;
        }
        return result;
    }
}
