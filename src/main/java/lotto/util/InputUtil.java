package lotto.util;

import java.util.Scanner;

public class InputUtil {


    private final static Scanner scanner = new Scanner(System.in);

    private InputUtil(){}

    public static String inputMoney(){
        return scanner.nextLine();
    }

    public static String enterLastWinningNumbers() {
        String lastWinningNumbers = scanner.nextLine().trim();
        return lastWinningNumbers;
    }

    public static String enterBonusNumber() {
        String bonusNumber = scanner.nextLine().trim();
        return bonusNumber;
    }
}
