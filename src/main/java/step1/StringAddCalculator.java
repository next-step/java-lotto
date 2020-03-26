package step1;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    public static int caculate(String input) {

        if(InputChecker.isNullOrEmpty(input)) {
            return 0;
        }
        if (InputChecker.isOnlyNumber(input)) {
            return Integer.parseInt(input);
        }
        String[] strings = input.split(",");

        Numbers numbers = new Numbers(convertToInteger(strings));
        return numbers.addAll();
    }

    private static List<Integer> convertToInteger(String[] strings) {
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < strings.length; i++) {
            numbers.add(Integer.parseInt(strings[i]));
        }
        return numbers;
    }
}
