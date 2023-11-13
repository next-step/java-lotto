package calculator.ui;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CALCULATOR_SEPARATOR = " ";

    public static List<String> input() {
        System.out.println("계산식을 입력해주세요.");
        return List.of(SCANNER.nextLine().split(CALCULATOR_SEPARATOR));
    }
}
