package lotto.util;

import java.util.Scanner;

public class InputUtil {

    private final static Scanner scanner = new Scanner(System.in);

    public static String inputMoney(){
        return scanner.nextLine();
    }

    public static String enterLastWinningNumbers() {
        String lastWinningNumbers = scanner.nextLine();
        return lastWinningNumbers;
    }
}
