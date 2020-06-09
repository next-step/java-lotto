package lotto;

import lotto.domain.AutoLottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Price;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Price price = inputView.insertPrice();

        List<List<Integer>> manualLottoNumbersList = inputView.insertManualLottoNumberList();

        LottoMachine lottoMachine = new LottoMachine(new AutoLottoGenerator());
        List<Lotto> lottoList = lottoMachine.buy(price, manualLottoNumbersList);
        resultView.printLottoCount(manualLottoNumbersList.size(), lottoList.size() - manualLottoNumbersList.size());

        lottoList.forEach(resultView::printLotto);

        Lotto winLotto = inputView.insertWinLotto();
        int bonusNumber = inputView.insertBonusNumber();
        resultView.printStatistic(price, winLotto, bonusNumber, lottoList);
    }
}
