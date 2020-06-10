package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
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

        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.buy(price, manualLottoNumbersList);
        resultView.printLottoCount(manualLottoNumbersList.size(), lottos.size() - manualLottoNumbersList.size());

        lottos.forEach(resultView::printLotto);

        Lotto winLotto = inputView.insertWinLotto();
        int bonusNumber = inputView.insertBonusNumber();
        resultView.printStatistic(price, winLotto, bonusNumber, lottos);
    }
}
