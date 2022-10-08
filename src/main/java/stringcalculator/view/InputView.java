package stringcalculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getInput() {
        System.out.println("계산식을 입력하세요.");
        String input = scanner.nextLine();
        String[] texts = input.split(" ");
        return Arrays.asList(texts);
    }
}
