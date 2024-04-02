package lotto.view;

import lotto.domain.LottoFee;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String QUESTION_START = "구입금액을 입력해 주세요.";
    private static final String ANSWER_GAME_COUNT = "개를 구매했습니다.";
    private static final String QUESTION_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static LottoFee payForGames() {
        System.out.println(QUESTION_START);
        LottoFee lottoFee = new LottoFee(SCANNER.nextInt());
        System.out.println(lottoFee.convertToGameUnit()+ANSWER_GAME_COUNT);
        SCANNER.nextLine();
        return lottoFee;
    }

    public static String[] inputWinningNumber() {
        System.out.println(QUESTION_WINNING_NUMBER);
        return SCANNER.nextLine().split(", ");
    }

    public static int inputBonusNumber() {
        System.out.println(QUESTION_BONUS_NUMBER);
        return parseInt(SCANNER.nextLine());
    }
}
