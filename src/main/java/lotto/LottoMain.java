package lotto;

import lotto.domain.LottoGames;
import lotto.domain.WinningLotto;
import lotto.domain.number.LottoNumber;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoGames lottoGames = new LottoGames(Util.convertInt(inputView.inputPurchaseAmount()));
        resultView.printLottoNumbers(lottoGames);
        WinningLotto firstLotto = new WinningLotto(inputView.inputFirstLottoNumber());
        LottoNumber bonusLottoNumber = new LottoNumber(Util.convertInt(inputView.inputBonusLottoNumber()));
        lottoGames.calculatePrizeCount(firstLotto, bonusLottoNumber);
        resultView.printLottoResult(lottoGames);
    }
}
