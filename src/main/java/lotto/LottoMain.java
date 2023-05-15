package lotto;

import lotto.domain.LottoGames;
import lotto.domain.LottoPurchase;
import lotto.domain.WinningLotto;
import lotto.domain.number.LottoNumber;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        String purchaseAmount = inputView.inputPurchaseAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);
        resultView.printLottoPurchaseCount(lottoPurchase);

        LottoGames lottoGames = new LottoGames(lottoPurchase);
        resultView.printLottoNumbers(lottoGames);

        WinningLotto firstLotto = new WinningLotto(inputView.inputFirstLottoNumber());
        LottoNumber bonusLottoNumber = new LottoNumber(Util.convertInt(inputView.inputBonusLottoNumber()));

        lottoGames.calculatePrizeCount(firstLotto, bonusLottoNumber);
        resultView.printLottoResult(lottoGames);
    }
}
