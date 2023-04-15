package calculator.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = "\\s+";


    public static String[] inputExpression() {
        System.out.println("계산할 문자열을 입력해주세요.");
        System.out.println("입력 값은 공백 기준으로 분리되며 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정됩니다.");
        System.out.println("예시) 2 + 3 * 4 / 2 = 10");

        return scanner.nextLine().split(DELIMITER);
    }

}
