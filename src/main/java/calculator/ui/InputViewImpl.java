package calculator.ui;

import java.util.Scanner;

public class InputViewImpl implements InputView{
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String inputExpression() {
        System.out.println("수행할 사칙연산식을 입력하세요.");
        return sc.nextLine();
    }
}
