package lotto;

import lotto.controller.LottoController;
import lotto.domain.repository.Lottos;
import lotto.domain.repository.Numbers;
import lotto.domain.service.WinningRankStatistics;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        int money = lottoController.getMoney();
        int lottoNum = lottoController.getLottoNum(money);

        Lottos lottos = lottoController.createLottos(lottoNum);
        Numbers winningNumbers = lottoController.getWinningNumbers();

        WinningRankStatistics statistics = lottoController.analyze(lottos, winningNumbers);

        lottoController.showResult(statistics);
    }
}
