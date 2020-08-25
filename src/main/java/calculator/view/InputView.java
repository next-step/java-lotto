package calculator.view;

import java.util.Scanner;

public class InputView {
    public static String inputString() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산할 문자열을 입력하세요.");
        return scanner.nextLine();
    }
}
