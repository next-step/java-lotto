package calculator;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        System.out.println(" 빈 공백 문자열을 포함하여 숫자와 연산자를 입력해주세요.");
        String input = SCANNER.nextLine();
        Validation.checkNullOrBlank(input);
        System.out.println(calculator.calculate(input));
    }
}
