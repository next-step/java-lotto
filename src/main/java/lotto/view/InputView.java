package lotto.view;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    private static final String INPUT_MONEY = "구입급액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        return scanner.nextInt();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return scanner.nextInt();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        scanner.nextLine();
        return scanner.nextLine();
    }
}
