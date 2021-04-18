package lotto.ui;

import java.util.Scanner;

public class InputView {
    private final static String GET_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String GET_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String GET_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private final static String GET_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String GET_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private final static Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println(GET_PURCHASE_AMOUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getWinningNumber() {
        System.out.println(GET_WINNING_NUMBER);
        return scanner.nextLine();
    }

    public static String getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER);
        return scanner.nextLine();
    }

    public static int getManualLotto() {
        System.out.println(GET_MANUAL_LOTTO);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void printManualLottoNumbers() {
        System.out.println(GET_MANUAL_LOTTO_NUMBERS);
    }

    public static String getManualLottoNumbers() {
        return scanner.nextLine();
    }
}
