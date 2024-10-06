package stringCalculator.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringCalculatorInputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> getExpression() {
        System.out.println("수식을 입력하세요 (예: 2 + 3 * 4 / 2):");
        String input = SCANNER.nextLine();

        return Arrays.asList(input.split(" "));
    }


}
