package step2.domain;

import step2.util.BasicLottoStrategy;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LottoGame {
    public static void run() {
        int money = InputView.inputMoney();
        LottosCount lottosCount = InputView.countLottos(money);
        List<Lotto> manualLottoList = InputView.buyLottosManual(lottosCount.getManual());

        LottoFactory lottoFactory = new LottoFactory(new BasicLottoStrategy());

        Lottos manaulLottos = lottoFactory.buyManual(manualLottoList);
        Lottos autoLottos = lottoFactory.buyAuto(lottosCount.getAuto());

        Lottos lottos = Lottos.merge(manaulLottos, autoLottos);

        OutputView.lottoCount(lottos, lottosCount);

        Winning winning = InputView.winningNumsLastWeek();
        Statistics statistics = Statistics.from(lottos, winning);
        OutputView.strategy(statistics, money);
    }
}
