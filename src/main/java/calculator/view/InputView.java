package calculator.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String inputStringAdditionCalculator() {
        System.out.println("====문자열 덧셈 계산기====");
        System.out.println("문자열을 입력하세요: ");
        return scanner.nextLine();
    }

}
