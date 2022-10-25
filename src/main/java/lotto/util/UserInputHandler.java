package lotto.util;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class UserInputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int scanMoney(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("올바르지 않은 숫자가 입력되었습니다.");
        }
    }

    public static int scanMoney() {
        return scanMoney(scan());
    }

    public static String scan() {
        return scanner.nextLine();
    }
}
