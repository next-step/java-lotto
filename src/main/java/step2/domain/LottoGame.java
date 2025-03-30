package step2.domain;

import step2.util.BasicLottoStrategy;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoGame {
    public static void run() {
        int money = InputView.inputMoney();
        LottosCount lottosCount = InputView.countLottos(money);

        Lottos manaulLottos = InputView.buyLottosManual(lottosCount.getManual());

        LottoFactory lottoFactory = new LottoFactory(new BasicLottoStrategy());
        Lottos autoLottos = lottoFactory.buy(lottosCount);

        Lottos lottos = Lottos.merge(manaulLottos, autoLottos);

        OutputView.lottoCount(lottos);

        Winning winning = InputView.winningNumsLastWeek();
        Statistics statistics = Statistics.from(lottos, winning);
        OutputView.strategy(statistics, money);
    }
}
