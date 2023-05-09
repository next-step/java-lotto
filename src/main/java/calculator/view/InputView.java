package calculator.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String askFormula() {
        System.out.println("수식을 입력해주세요(입력한 문자열인 숫자와 사칙 연산자 사이에는 빈 문자열이 입력되어야 합니다.)");

        return scanner.nextLine().trim();
    }
}
