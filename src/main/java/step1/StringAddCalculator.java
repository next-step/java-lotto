package step1;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {


    public static int splitAndSum(String inputData) {
        String[] splits = inputData.split(",|:");
        List<Integer> numbers = new ArrayList<>();
        int result = 0;
        for (String number : splits) {
            numbers.add(Integer.parseInt(number));
        }
        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }
}
