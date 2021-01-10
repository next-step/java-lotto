package lotto.util;

import java.util.Scanner;

public class InputUtil {


    private final static Scanner scanner = new Scanner(System.in);

    private InputUtil(){}

    public static String inputMoney(){
        return getScannerWithTrim();
    }

    public static String enterLastWinningNumbers() {
        String lastWinningNumbers = getScannerWithTrim();
        return lastWinningNumbers;
    }

    public static String enterBonusNumber() {
        String bonusNumber = getScannerWithTrim();
        return bonusNumber;
    }

    public static String enterManualLottoSize() {
        String manualLottoCount = getScannerWithTrim();
        return manualLottoCount;
    }

    public static String inputManualLottoNumber() {
        String manualLottoNumber = getScannerWithTrim();
        return manualLottoNumber;
    }

    private static String getScannerWithTrim() {
        return scanner.nextLine().trim();
    }
}
