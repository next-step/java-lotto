package step1;

import java.util.ArrayList;
import java.util.List;

import static step1.Numbers.INIT_VALUE;

public class StringAddCalculator {
    public static int calculate(String input) {
        if(InputChecker.isNullOrEmpty(input)) {
            return INIT_VALUE;
        }

        String[] strings = input.split(",|:");
        Numbers numbers = new Numbers(strings);

        return numbers.addAll();
    }
}
