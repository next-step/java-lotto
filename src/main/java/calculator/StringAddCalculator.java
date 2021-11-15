package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    //쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
    public static int splitAndSum(String input){
        if(isEmptyOrNull(input)) return 0;
        String[] numbers = input.split(",");
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

    private static boolean isEmptyOrNull(String input){
        return input == null || input.trim().isEmpty();
    }
}