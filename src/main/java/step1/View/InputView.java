package step1.View;

import step1.Util.StringUtil;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputDate() {
        String input = scanner.nextLine();
        if (StringUtil.isNullOrEmpty(input)) {
            throw new RuntimeException();
        }
        return input;
    }

}
