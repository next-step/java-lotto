package step2;

import step2.domain.lotto.LottoCount;
import step2.domain.LottoGame;
import step2.domain.LottoGameResult;
import step2.domain.lotto.*;
import views.InputView;
import views.ResultView;

import java.util.List;

public class LottoGameApplication {

    public static final int LOTTO_TICKET_PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int PICKS_PER_TICKET = 6;

    public static void main(String[] args) {
        LottoCount lottoCount = createLottoCountWithQuery();
        LottoGame lottoGame = setUpLottoGame(lottoCount);

        ResultView.printMessage("");
        ResultView.printMessage(lottoGame.purchasedLottosAsString());

        LottoGameResult lottoGameResult = playLottoRound(lottoGame);

        ResultView.showGameSummary(lottoCount, lottoGameResult);
    }

    private static LottoGameResult playLottoRound(LottoGame lottoGame) {
        List<Integer> winningNumbers = InputView.promptForIntegerList("지난 주 당첨 번호를 입력해 주세요.", ",");
        Integer bonusNumber = InputView.promptForInteger("보너스 볼을 입력해 주세요.");
        return lottoGame.play(winningNumbers, bonusNumber);
    }

    private static LottoGame setUpLottoGame(LottoCount lottoCount) {
        LottoRule lottoRule = new LottoRule(MIN_NUMBER, MAX_NUMBER, PICKS_PER_TICKET);
        return new LottoGame(lottoCount, lottoRule);
    }

    private static LottoCount createLottoCountWithQuery() {
        LottoCount lottoCount = null;
        while (lottoCount == null) {
            int purchaseAmount = InputView.promptForInteger("구입금액을 입력해 주세요.");
            lottoCount = createLottoCount(purchaseAmount);
        }
        return lottoCount;
    }

    private static LottoCount createLottoCount(int purchaseAmount) {
        try {
            return new LottoCount(purchaseAmount, LOTTO_TICKET_PRICE);
        } catch (IllegalArgumentException e) {
            ResultView.printMessage(e.getMessage());
        }
        return null;
    }
}
