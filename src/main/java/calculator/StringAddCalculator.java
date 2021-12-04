package calculator;

import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String number) {
        Delimiter delimiter = new Delimiter();
        if (!delimiter.isEmpty(number)) {
            return 0;
        }
        List<String> splitList = delimiter.split(number);

        Numbers textNumbers = new Numbers(splitList);
        return textNumbers.getResult();
    }
}
