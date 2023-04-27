package stringcalculator.view;

import java.util.Scanner;

public class InputView {
    public String promptExpression() {
        System.out.println("계산식을 입력하세요.(숫자와 연산자 사이는 띄워쓰기 필요 / 사칙연산자만 가능)");
        return new Scanner(System.in).nextLine();
    }
}
