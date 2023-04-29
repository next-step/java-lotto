package lotto.step1.view;

import lotto.step1.domain.Calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_TEXT1 = "문자열 계산기 입니다.";
    public static final String INPUT_TEXT2 = "입력 문자열의 숫자와 사칙 연산을 입력해주세요.(숫자와 연산자 사이는 공백 필수, ex. 2 + 3 * 4 / 2)";
    public static final String INPUT_DELIMITER = " ";

    public Calculator inputData() {
        System.out.println(INPUT_TEXT1);
        System.out.println(INPUT_TEXT2);
        String[] input = SCANNER.nextLine().split(INPUT_DELIMITER);
        return new Calculator(Arrays.asList(input));
    }
}
