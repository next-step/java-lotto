package step3;

import step3.config.AppConfig;
import step3.domain.lotto.Lotto;
import step3.domain.money.Money;
import step3.domain.winning.WinningLotto;
import step3.domain.winning.WinningResult;
import step3.service.LottoService;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public final class LottoApplication {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoService lottoService;

    private LottoApplication() {
        this.inputView = InputView.getInstance();
        this.resultView = ResultView.getInstance();
        this.lottoService = LottoService.getInstance(AppConfig.lottoShuffleStrategy());
    }

    public static final LottoApplication newInstance() {
        return new LottoApplication();
    }

    public final void start() {
        generateAndShowLottoList();
    }

    public final void generateAndShowLottoList() {
        Money money = inputView.getMoneyByClient();
        List<Lotto> userLottos = lottoService.buyLottos(money);
        resultView.printLottoList(userLottos);

        WinningLotto winningLotto = inputView.getWinningLottoByClient();
        WinningResult winningResult = lottoService.matchWinningLotto(userLottos, winningLotto);
        resultView.printLottoResult(winningResult, money);

    }

}
