package stringcalculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getExpression() {
        System.out.println(",혹은 :로 구분된 덧셈 식을 입력하세요 (ex. \"1,2\", \"1;2\")");
        return scanner.nextLine().replace("\\n", "\n");
    }
}
