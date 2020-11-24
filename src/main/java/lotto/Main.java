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
        int manualLottoNumber = lottoController.getManualLottoNumber();

        Purchase purchase = new Purchase(money, manualLottoNumber);

        Lottos lottos = purchase.drawLottosByMeans(LottoController::getManualLottosNumbers, LottoController::createLottos);

        Numbers winningNumbers = lottoController.getWinningNumbers();

        Number bonus = lottoController.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

        WinningChecker winningChecker = new WinningChecker(winningLotto);

        WinningRanks winningRanks = winningChecker.getWinningRanks(lottos);

        WinningRankStatistics winningRankStatistics = new WinningRankStatistics(winningRanks);

        lottoController.showResult(winningRankStatistics);
    }
}
