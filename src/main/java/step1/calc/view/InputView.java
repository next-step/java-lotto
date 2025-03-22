package step1.calc.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getExpression() {
        System.out.println("계산할 식을 입력해 주세요.");
        return Arrays.asList(scanner.nextLine().split(" "));
    }
}
