package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final String MONEY_INPUT_GUIDE = "구매 금액을 입력해주세요.";
    private static final String WINNING_LOTTO_INPUT_GUIDE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_LOTTO_INPUT_GUIDE = "보너스 볼을 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(MONEY_INPUT_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String inputWinningLottoNumbers() {
        System.out.println(WINNING_LOTTO_INPUT_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int inputBonusLottoNumber() {
        System.out.println(BONUS_LOTTO_INPUT_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
