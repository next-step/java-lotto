package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        executeLotto();
    }

    private static void executeLotto() {
        String money = InputView.inputMoney();
        String manualLottoCount = InputView.inputManualLottoCount();
        List<String> manualLottoNumbers = InputView.inputManualLottoNumbers(Integer.parseInt(manualLottoCount));

        Lottos lottos = buyLotto(money, manualLottoNumbers);
        generateStatistics(lottos, money);
    }

    private static Lottos buyLotto(String money, List<String> manualLottoNumbers) {
        Lottos lottos = LottoController.generateLotto(money, manualLottoNumbers);
        ResultView.printLottos(lottos, manualLottoNumbers.size());
        return lottos;
    }

    private static void generateStatistics(Lottos lottos, String money) {
        String winnerNumber = InputView.inputWinnerNumber();
        int bonusNumber = InputView.inputBonusNumber();

        Statistics statistics = LottoController.generateStatistics(lottos, winnerNumber, bonusNumber);
        ResultView.printStatistics(statistics);

        double rateOfReturn = LottoController.findRateOfReturn(money, statistics);
        ResultView.printRateOfReturn(rateOfReturn);
    }
}
