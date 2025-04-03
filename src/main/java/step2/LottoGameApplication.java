package step2;

import step2.domain.PurchaseAmount;
import step2.domain.lotto.LottoPurchaseManager;
import step2.domain.LottoGame;
import step2.domain.LottoGameResult;
import step2.domain.lotto.*;
import views.InputView;
import views.ResultView;

import java.util.List;

public class LottoGameApplication {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public static void main(String[] args) {
        LottoPurchaseManager lottoPurchaseManager = createLottoCountWithQuery();
        LottoGame lottoGame = setUpLottoGame(lottoPurchaseManager);

        ResultView.printMessage("");
        ResultView.printMessage(lottoGame.purchasedLottosAsString());

        LottoGameResult lottoGameResult = playLottoRound(lottoGame);

        ResultView.showGameSummary(lottoPurchaseManager, lottoGameResult);
    }

    private static LottoGameResult playLottoRound(LottoGame lottoGame) {
        List<Integer> winningNumbers = InputView.promptForIntegerList("지난 주 당첨 번호를 입력해 주세요.", ",");
        Integer bonusNumber = InputView.promptForInteger("보너스 볼을 입력해 주세요.");
        return lottoGame.play(winningNumbers, bonusNumber);
    }

    private static LottoGame setUpLottoGame(LottoPurchaseManager lottoPurchaseManager) {
        LottoGenerator lottoGenerator = new LottoGenerator(LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.NUMBERS_PER_LOTTO);
        return new LottoGame(lottoPurchaseManager, lottoGenerator);
    }

    private static LottoPurchaseManager createLottoCountWithQuery() {
        LottoPurchaseManager lottoPurchaseManager = null;
        while (lottoPurchaseManager == null) {
            int purchaseAmount = InputView.promptForInteger("구입금액을 입력해 주세요.");
            lottoPurchaseManager = createLottoCount(purchaseAmount);
        }
        return lottoPurchaseManager;
    }

    private static LottoPurchaseManager createLottoCount(int inputAmount) {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
            return new LottoPurchaseManager(purchaseAmount, LOTTO_TICKET_PRICE, 0);
        } catch (IllegalArgumentException e) {
            ResultView.printMessage(e.getMessage());
        }
        return null;
    }
}
