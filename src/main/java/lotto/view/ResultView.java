package lotto.view;

import lotto.LottoGameController;
import lotto.domain.winning.WinningNumber;

/**
 * Created By mand2 on 2020-11-18.
 */
public class ResultView {

    private static final String QUESTION_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public static WinningNumber askWinningNumber() {
        System.out.println(QUESTION_WINNING_NUMBER);

        return WinningNumber.of(LottoGameController.SCANNER.nextLine());
    }

}
