package stringCalculator.view;

import java.util.Scanner;

public class Input {

    private final static Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static String inputNumericFormula() {
        System.out.println("수식을 입력해주세요");
        return scanner.nextLine();
    }
}
