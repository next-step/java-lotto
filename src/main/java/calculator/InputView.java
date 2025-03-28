package calculator;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static String getCalculationFormula() {
        System.out.println("계산할 문자열을 입력하세요.");
        return scanner.nextLine();
    }
}
