package step1;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int result = 0;

        if(InputChecker.isNullOrEmpty(input)) {
            result = 0;
        }
        else if(InputChecker.isOnlyNumber(input)) {
            result = Integer.parseInt(input);
        }
        else {
            String[] strings = input.split(",");
            Numbers numbers = new Numbers(convertToInteger(strings));
            result = numbers.addAll();
        }
        return result;
    }

    private static List<Integer> convertToInteger(String[] strings) {
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < strings.length; i++) {
            numbers.add(Integer.parseInt(strings[i]));
        }
        return numbers;
    }
}
