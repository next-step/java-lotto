package lotto;

import lotto.controller.LottoController;
import lotto.domain.Number;
import lotto.domain.*;
import lotto.service.WinningChecker;
import lotto.service.WinningRankStatistics;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        int money = lottoController.getMoney();
        int lottoNum = lottoController.getLottoNum(money);

        Lottos lottos = lottoController.createLottos(lottoNum);

        Numbers winningNumbers = lottoController.getWinningNumbers();

        Number bonus = lottoController.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

        WinningChecker winningChecker = new WinningChecker(winningLotto);

        WinningRanks winningRanks = winningChecker.checkRanks(lottos);

        WinningRankStatistics winningRankStatistics = new WinningRankStatistics(winningRanks);

        lottoController.showResult(winningRankStatistics);
    }
}
