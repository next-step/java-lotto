package lotto;

import lotto.controller.LottoController;
import lotto.domain.LotteryMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningRankStatistics;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        int money = lottoController.getMoney();
        int lottoNum = lottoController.getLottoNum(money);

        Lottos lottos = lottoController.createLottos(lottoNum);
        LotteryMachine lotteryMachine = lottoController.getWinningNumbers();
        WinningRankStatistics statistics = lottoController.analyze(lotteryMachine, lottos);

        lottoController.showResult(statistics);
    }
}
