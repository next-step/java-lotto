package lotto.view;

import lotto.LottoGameController;
import lotto.domain.SeedMoney;
import lotto.domain.winning.WinningNumber;

/**
 * Created By mand2 on 2020-11-19.
 */
public class InputView {

    private static final String QUESTION_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String QUESTION_GAME_MONEY = "구입금액을 입력해 주세요.";
    private static final String SHOW_GAME_MONEY = "%d개를 구매했습니다.";

    public static SeedMoney askAndShowLottoGameMoney() {
        SeedMoney seedMoney = askSeedMoney();
        showGameRound(seedMoney.round());

        return seedMoney;
    }

    private static SeedMoney askSeedMoney() {
        System.out.println(QUESTION_GAME_MONEY);
        return SeedMoney.from(LottoGameController.SCANNER.nextLine());
    }

    private static void showGameRound(int amount) {
        System.out.println(String.format(SHOW_GAME_MONEY, amount));
    }


    public static WinningNumber askWinningNumberAndBonus() {
        return WinningNumber.of(askWinningNumber(), askBonusBall());
    }

    private static String askWinningNumber() {
        System.out.println(QUESTION_WINNING_NUMBER);
        return LottoGameController.SCANNER.nextLine();
    }

    private static String askBonusBall() {
        System.out.println(QUESTION_BONUS_BALL);
        return LottoGameController.SCANNER.nextLine();
    }

}
