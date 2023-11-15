package step1.view;

import java.util.Scanner;

public class OperatorInputView {

    public static final String PUT_FORMULA = "연산식을 입력해주세요.";

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PUT_FORMULA);
        return scanner.nextLine();
    }
}
