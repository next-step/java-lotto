package step2;

import step2.domain.LottoFactory;
import step2.domain.Lottos;
import step2.domain.Statistics;
import step2.domain.Winning;
import step2.util.BasicLottoStrategy;
import step2.view.InputView;
import step2.view.OutputView;

public class Main {
    public void LottoGame() {
        int money = InputView.buyLottosMoney();
        LottoFactory lottoFactory = new LottoFactory(new BasicLottoStrategy());
        Lottos lottos = lottoFactory.buy(money);
        OutputView.lottoCount(lottos);

        Winning winning = InputView.winningNumsLastWeek();
        Statistics statistics = Statistics.from(lottos, winning);
        OutputView.strategy(statistics, money);
    }
}
