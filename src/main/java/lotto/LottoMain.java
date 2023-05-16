package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGames;
import lotto.domain.LottoPurchase;
import lotto.domain.number.LottoNumber;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        String purchaseAmount = inputView.inputPurchaseAmount();
        String manualAmount = inputView.inputManualAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount, manualAmount);
        List<Lotto> manualLotto = inputView.inputManualLottoNumber(lottoPurchase);
        resultView.printLottoPurchaseCount(lottoPurchase);

        LottoGames lottoGames = new LottoGames(lottoPurchase, manualLotto);
        resultView.printLottoNumbers(lottoGames);

        Lotto firstLotto = inputView.inputWinningLottoNumber();
        LottoNumber bonusLottoNumber = new LottoNumber(Util.convertInt(inputView.inputBonusLottoNumber()));

        lottoGames.calculatePrizeCount(firstLotto, bonusLottoNumber);
        resultView.printLottoResult(lottoGames);
    }
}
