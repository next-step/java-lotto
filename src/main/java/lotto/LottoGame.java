package lotto;

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

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottoList = lottoMachine.buy(price);
        resultView.printLottoCount(lottoList.size());

        lottoList.forEach(resultView::printLotto);

        Lotto winLotto = inputView.insertWinLotto();
    }
}
