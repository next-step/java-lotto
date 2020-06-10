package calculator;

import java.util.List;

public class StringAddCalculator {

    private StringAddCalculator(){

    }

    public static int splitAndSum(String inputString) {

        if (ParserUtils.checkValid(inputString)) {
            return 0;
        }

        List<Integer> numberlist = ParserUtils.stringToArray(inputString);

        int sum = 0;
        for (int number : numberlist) {
            sum += number;
        }

        return sum;
    }


}
