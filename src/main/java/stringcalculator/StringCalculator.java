package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static Integer calculate(String s) {

        String[] aa = s.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for(String a : aa) {
            if("+".equals(a)) {
                continue;
            }
            numbers.add(Integer.parseInt(a));
        }

        int result = 0;
        for(Integer number : numbers) {
            result += number;
        }

        return result;
    }
}
