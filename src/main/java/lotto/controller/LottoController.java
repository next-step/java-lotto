package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoController {

    public void startLotto() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int price = inputView.inputLottoPrice();

        Money money = new Money(price);

        int lottoCount = money.buyCount();
        resultView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        resultView.printLottos(lottos);

        String winningLottoNumbers = inputView.inputWinningLotto();
        Statistics statistics = new Statistics(winningLottoNumbers);
        Map<Rank, Integer> lottoRankMap = statistics.getStatistics(lottos.getLottos());
        resultView.printLottoRank(lottoRankMap, money);
    }
}
