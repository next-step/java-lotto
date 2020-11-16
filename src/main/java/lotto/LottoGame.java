package lotto;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.service.StatisticPrinter;
import lotto.view.ConsoleView;
import lotto.view.View;
import lotto.view.inputview.ConsoleInputView;
import lotto.view.inputview.InputView;
import lotto.view.resultview.ConsoleResultView;
import lotto.view.resultview.ResultView;

public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();
        View view = new ConsoleView(inputView, resultView);
        LottoService lottoService = new LottoService(view);
        StatisticPrinter statisticPrinter = new StatisticPrinter(view);
        Lottos boughtLottos = lottoService.buyLottos();
        if (boughtLottos.isEmpty()) {
            return;
        }
        statisticPrinter.printStatistic(boughtLottos);
    }
}
