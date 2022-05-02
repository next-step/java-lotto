package controller;

import domain.BuyLotto;
import domain.LottoStatistics;
import domain.LottoWinningNumbers;
import view.InputView;
import view.ResultView;

public class LottoGame {
    public static void main(String[] args) {
        BuyLotto buyLotto = new BuyLotto(InputView.inputHowMoney());
        ResultView.printHowLottoCount(buyLotto.buyLottoCount());
        ResultView.printLottoList(buyLotto.buyLottoList());

        ResultView.printStatistics(new LottoStatistics(buyLotto
                , new LottoWinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumber())));
    }
}
