package lotto.view;

import lotto.domain.Fee;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String QUESTION_START = "구입금액을 입력해 주세요.";
    private static final String ANSWER_GAME_COUNT = "개를 구매했습니다.";

    public static Fee payForGames() {
        System.out.println(QUESTION_START);
        Fee fee = new Fee(SCANNER.nextInt());
        System.out.println(fee.convertToGameUnit()+ANSWER_GAME_COUNT);
        return fee;
    }
}
