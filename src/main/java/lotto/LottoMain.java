package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGames;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        String purchaseAmount = inputView.inputPurchaseAmount();
        LottoGames lottoGames = new LottoGames(Integer.parseInt(purchaseAmount));
        String firstLottoNumber = inputView.inputFirstLottoNumber();
        Lotto firstLotto = new Lotto(firstLottoNumber);
        lottoGames.calculatePrizeCount(firstLotto);
        resultView.printLottoResult(lottoGames);
    }
}
