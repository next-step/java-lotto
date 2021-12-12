package step2.view;

import step2.domain.Money;
import step2.exception.NotInstanceException;

import java.util.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String ASK_BUY_PRICE = "구입금액을 입력해 주세요.";
    private static final String ASK_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";

    private InputView() {
        throw new NotInstanceException();
    }

    public static Money inputAmount() {
        System.out.println(ASK_BUY_PRICE);

        Money money = new Money(SCANNER.nextInt());
        SCANNER.nextLine();

        return money;
    }

    public static String pickWinningNumber() {
        System.out.println(ASK_LAST_WEEK_WINNING_NUMBER);

        return SCANNER.nextLine();
    }

    public static int pickBonusBallNumber() {
        System.out.println(ASK_BONUS_BALL_NUMBER);

        return SCANNER.nextInt();
    }
}
