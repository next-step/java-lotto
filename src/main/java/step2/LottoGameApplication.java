package step2;

import step2.domain.LottoGame;
import step2.domain.LottoGameResult;
import step2.domain.PurchaseAmount;
import step2.domain.lotto.LottoConstants;
import step2.domain.lotto.LottoContainer;
import step2.domain.lotto.LottoCount;
import step2.domain.lotto.LottoGenerator;
import views.InputView;
import views.LottoInputView;
import views.ResultView;

import java.util.List;

import static views.LottoInputView.createManualLottoCountWithQuery;

public class LottoGameApplication {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = createPurchaseAmountWithQuery();
        LottoCount totalLottoCount = createLottoCountWithQuery(purchaseAmount);
        LottoCount manualLottoCount = createManualLottoCountWithQuery(totalLottoCount);

        LottoGame lottoGame = setUpLottoGame(totalLottoCount, manualLottoCount);
        ResultView.showPurchasedLotto(lottoGame);

        LottoGameResult lottoGameResult = playLottoRound(lottoGame);
        ResultView.showGameSummary(purchaseAmount, lottoGameResult);
    }

    private static PurchaseAmount createPurchaseAmountWithQuery() {
        int purchaseAmountInput = InputView.promptForInteger("구입금액을 입력해 주세요.");
        return new PurchaseAmount(purchaseAmountInput);
    }

    private static LottoGameResult playLottoRound(LottoGame lottoGame) {
        List<Integer> winningNumbers = InputView.promptForIntegerList("지난 주 당첨 번호를 입력해 주세요.", ",");
        Integer bonusNumber = InputView.promptForInteger("보너스 볼을 입력해 주세요.");
        return lottoGame.play(winningNumbers, bonusNumber);
    }

    private static LottoGame setUpLottoGame(LottoCount totalLottoCount, LottoCount manualLottoCount) {
        LottoGenerator lottoGenerator = new LottoGenerator(LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.NUMBERS_PER_LOTTO);
        LottoContainer manualLottoContainer = LottoInputView.manualLottoInput(manualLottoCount);

        LottoCount autoLottoCount = totalLottoCount.subtract(manualLottoCount);
        LottoContainer autoLottoContainer = new LottoContainer(autoLottoCount.value(), lottoGenerator);

        return new LottoGame(manualLottoContainer.add(autoLottoContainer));
    }

    private static LottoCount createLottoCountWithQuery(PurchaseAmount purchaseAmount) {
        LottoCount lottoCount = null;
        while (lottoCount == null) {
            lottoCount = purchaseAmount.getLottoCount(LOTTO_TICKET_PRICE);
        }
        return lottoCount;
    }
}
