package stringcalcaulator.view;

import java.util.Scanner;

public class StringCalculatorInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String getInput() {
        System.out.println("계산할 문자열을 입력하세요.");
        return SCANNER.nextLine();
    }
}
