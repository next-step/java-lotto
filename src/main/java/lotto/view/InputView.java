package lotto.view;

import lotto.LottoGameController;
import lotto.domain.InputManualLotto;
import lotto.domain.SeedMoney;
import lotto.domain.game.Round;
import lotto.domain.winning.WinningNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created By mand2 on 2020-11-19.
 */
public class InputView {

    private static final String QUESTION_WINNING_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String QUESTION_GAME_MONEY = "구입금액을 입력해 주세요.";
    private static final String QUESTION_MANUAL_ROUNDS = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUESTION_MANUAL_LOTTOS = "\n수동으로 구매할 번호를 입력해 주세요.";

    public static SeedMoney askSeedMoney() {
        System.out.println(QUESTION_GAME_MONEY);
        return SeedMoney.from(LottoGameController.SCANNER.nextLine());
    }

    public static InputManualLotto askManualRoundsAndLottos() {
        Round round = askManualRounds();
        return InputManualLotto.of(round, askManualLottos(round));
    }

    private static Round askManualRounds() {
        System.out.println(QUESTION_MANUAL_ROUNDS);
        return Round.from(LottoGameController.SCANNER.nextLine());
    }

    private static List<String> askManualLottos(Round round) {
        System.out.println(QUESTION_MANUAL_LOTTOS);
        return IntStream.range(0, round.getRound())
                .mapToObj(i -> LottoGameController.SCANNER.nextLine())
                .collect(Collectors.toList());
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
