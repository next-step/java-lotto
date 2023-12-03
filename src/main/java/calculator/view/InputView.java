package calculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> getUserInput() {
        System.out.println("계산식 문자열을 입력하세요 (예:5 + 2 * 3)");
        String input = scanner.nextLine();

        List<String> numbersAndSigns = Arrays.asList(input.split(" "));
        return numbersAndSigns;

    }
}
