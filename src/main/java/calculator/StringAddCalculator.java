package calculator;

import java.util.List;

public class StringAddCalculator {


    public int splitAndSum(String inputString) {

        if (ParserUtils.checkNull(inputString)) {
            return 0;
        }

        if (ParserUtils.checkEmpty(inputString)) {
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
