package textAddCalculator.domain;

import textAddCalculator.utils.Splitter;

import static textAddCalculator.utils.ValidationChecker.exceptionCheck;
import static textAddCalculator.utils.ValidationChecker.isEmptyOrNull;

public class Calculator {

    public int splitAndSum(String text) {
        String[] numArr = Splitter.split(!isEmptyOrNull(text) ? text : "0");
        exceptionCheck(numArr);

        int resultNum = Integer.parseInt(numArr[0]);
        for(int i = 1; i < numArr.length; i++) {
            resultNum = add(resultNum, Integer.parseInt(numArr[i]));
        }

        return resultNum;
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }
}
