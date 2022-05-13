package study.step4.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNER_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";

    public int inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputWinnerNumbers() {
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
