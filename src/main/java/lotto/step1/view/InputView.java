package lotto.step1.view;

import lotto.step1.domain.Calculator;
import lotto.step1.domain.Input;
import lotto.step1.domain.MathOpQueue;
import lotto.step1.domain.NumberQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_TEXT1 = "문자열 계산기 입니다.";
    public static final String INPUT_TEXT2 = "입력 문자열의 숫자와 사칙 연산을 입력해주세요.(숫자와 연산자 사이는 공백 필수, ex. 2 + 3 * 4 / 2)";
    public static final String INPUT_DELIMITER = " ";

    public Calculator inputData() {
        System.out.println(INPUT_TEXT1);
        System.out.println(INPUT_TEXT2);
        String[] inputElement = SCANNER.nextLine().split(INPUT_DELIMITER);
        Input input = new Input(Arrays.asList(inputElement));
        NumberQueue numberQueue = new NumberQueue(new ArrayDeque<>());
        MathOpQueue mathOperationQueue = new MathOpQueue(new ArrayDeque<>());
        return new Calculator(input, numberQueue, mathOperationQueue);
    }
}
