package lotto.view;

import lotto.domain.Fee;
import lotto.domain.Lotto;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String QUESTION_START = "구입금액을 입력해 주세요.";
    private static final String ANSWER_GAME_COUNT = "개를 구매했습니다.";
    private static final String QUESTION_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public static Fee payForGames() {
        System.out.println(QUESTION_START);
        Fee fee = new Fee(SCANNER.nextInt());
        System.out.println(fee.convertToGameUnit()+ANSWER_GAME_COUNT);
        SCANNER.nextLine();
        return fee;
    }

    public static String[] inputWinningNumber() {
        System.out.println(QUESTION_WINNING_NUMBER);
        return SCANNER.nextLine().split(", ");
    }
}
