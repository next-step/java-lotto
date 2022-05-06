package controller;

import domain.BuyLotto;
import domain.LottoStatistics;
import domain.LottoWinningNumbers;
import view.InputView;
import view.ResultView;

public class LottoGame {
    public static void main(String[] args) {
        int buyMoney = InputView.inputHowMoney();
        int buyManualLottoCount = InputView.inputManualLottoCount();
        BuyLotto buyLotto = new BuyLotto(buyMoney, InputView.inputManualLottoNumbers(buyManualLottoCount));
        ResultView.printHowLottoCount(buyLotto.buyLottoCount(), buyManualLottoCount);
        ResultView.printLottoList(buyLotto.getLottos());

        ResultView.printStatistics(new LottoStatistics(buyLotto
                , new LottoWinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumber())));
    }
}
