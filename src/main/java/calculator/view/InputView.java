package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String askExpression() {
        System.out.println("계산할 수식을 입력해 주세요. 숫자와 연산자 사이에 공백을 입력해야 합니다.");

        return SCANNER.nextLine();
    }
}
