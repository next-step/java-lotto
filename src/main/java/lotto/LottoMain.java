package lotto;

import lotto.domain.LottoGames;
import lotto.domain.WinningLotto;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        String purchaseAmount = inputView.inputPurchaseAmount();
        LottoGames lottoGames = new LottoGames(Util.convertInt(purchaseAmount));
        String firstLottoNumber = inputView.inputFirstLottoNumber();
        WinningLotto firstLotto = new WinningLotto(firstLottoNumber);
        lottoGames.calculatePrizeCount(firstLotto);
        resultView.printLottoResult(lottoGames);
    }
}
