package step1;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {


    public static int splitAndSum(String inputData) {
        String[] splits = inputData.split(",|:");
        if (splits.length == 1) {
            return Integer.parseInt(splits[0]);
        }
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
