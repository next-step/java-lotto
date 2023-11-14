package calculator.view;

import java.util.Scanner;

public class View {

    public String getString() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산식을 입력하시오(숫자와 사칙 연산 사이에는 반드시 빈 공백이 있어야 함)");
        String input = scanner.nextLine();

        return input;
    }

    public void printResult(Integer result) {
        System.out.println("= " + result);
    }
}
