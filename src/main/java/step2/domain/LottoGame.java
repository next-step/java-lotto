package step2.domain;

import step2.util.BasicLottoStrategy;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoGame {
    public static void run() {
        int money = InputView.buyLottosMoney();
        LottoFactory lottoFactory = new LottoFactory(new BasicLottoStrategy());
        Lottos lottos = lottoFactory.buy(money);
        OutputView.lottoCount(lottos);

        Winning winning = InputView.winningNumsLastWeek();
        Statistics statistics = Statistics.from(lottos, winning);
        OutputView.strategy(statistics, money);
    }
}
