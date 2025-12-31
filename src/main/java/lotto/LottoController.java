package lotto;

import lotto.InputView;
import lotto.ResultView;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, ResultView resultView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        Money money = Money.of(inputView.readPurchaseAmount());

        List<Lotto> lottos = lottoMachine.issue(money);
        resultView.printLottos(lottos);

        Lotto winning = new Lotto(inputView.readWinningNumbers());

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(lottos, winning);

        resultView.printStatistics(stats, money);
    }
}
