package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        executeLotto();
    }

    private static void executeLotto() {
        String money = InputView.inputMoney();
        Lottos lottos = buyLotto(money);

        generateStatistics(lottos, money);
    }

    private static Lottos buyLotto(String money) {
        return LottoController.generateLotto(money);
    }

    private static void generateStatistics(Lottos lottos, String money) {
        String winnerNumber = InputView.inputWinnerNumber();
        int bonusNumber = InputView.inputBonusNumber();

        Statistics statistics = LottoController.generateStatistics(lottos, winnerNumber, bonusNumber);
        LottoController.findRateOfReturn(money, statistics);
    }
}
