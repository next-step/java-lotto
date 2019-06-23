package stringAddCalculator;

import java.util.Scanner;

public class InputView {
    public static String inputText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산할 문자열을 입력해 주세요!");
        return scanner.nextLine();
    }
}
