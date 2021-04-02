package step2;

import step2.domain.lotto.Lotto;
import step2.domain.winning.WinningResult;
import step2.service.LottoService;
import step2.domain.money.Money;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;
import java.util.Set;

public final class LottoApplication {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoService lottoService;

    private LottoApplication() {
        this.inputView = InputView.getInstance();
        this.resultView = ResultView.getInstance();
        this.lottoService = LottoService.of();
    }

    public static final LottoApplication newInstance() {
        return new LottoApplication();
    }

    public final void start() {
        generateAndShowLottoList();
    }

    public final void generateAndShowLottoList() {
        Money money = inputView.getMoneyByClient();
        List<Lotto> userLottos = lottoService.getLottos(money);
        resultView.printLottoList(userLottos);

        Lotto winningLotto = inputView.getWinningLottoByClient();
        WinningResult winningResult = lottoService.getWinningResult(userLottos, winningLotto);
        resultView.printLottoResult(winningResult, money);

    }

}
