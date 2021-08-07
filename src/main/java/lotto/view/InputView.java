package lotto.view;

import java.util.Scanner;

public class InputView {

    public static final String HOW_MUCH = "구입금액을 입력해 주세요.";
    public static final String LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private final static Scanner scanner = new Scanner(System.in);

    public static int howMuch() {
        System.out.println(HOW_MUCH);
        String text = scanner.nextLine();
        return Integer.parseInt(text);
    }

    public static String winningLotto() {
        System.out.println(LOTTO_NUMBER);
        return scanner.nextLine();
    }

    public static String bonusBall() {
        System.out.println(BONUS_BALL);
        return scanner.nextLine();
    }
}
