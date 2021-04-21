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

        int lottoCount = new Money().buyCount(price);
        resultView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        resultView.printLottos(lottos);

        String winningLottoNumbers = inputView.inputWinningLotto();
        Statistics statistics = new Statistics(lottos.getLottos(), winningLottoNumbers);
        Map<Rank, Integer> lottoRankMap = statistics.getStatistics();
        resultView.printLottoRank(lottoRankMap, price);
    }
}
