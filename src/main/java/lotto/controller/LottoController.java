package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.response.LottoResultResponse;
import lotto.request.ManualRequest;
import lotto.request.WinningLottoRequest;
import lotto.service.LottoService;
import lotto.util.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

        Money money = new Money(inputView.inputMoney().getMoney());
        ManualRequest manualRequest = inputView.inputManualLottoNumber();
        Lottos manualLotto = Lottos.from(manualRequest.getManualLottos());
        this.lottoService = LottoService.buyLotto(money, manualLotto, new RandomGenerator());

        outputView.printBuyStatus(lottoService.buyStatus());
    }

    public void drawWinningLotto() {
        WinningLottoRequest winningLottoRequest = inputView.inputWinningLotto();
        WinningLotto winningLotto = new WinningLotto(
                winningLottoRequest.getWinningNumbers(),
                winningLottoRequest.getBonusNumber()
        );

        LottoResults lottoResults = lottoService.matchWinningLotto(winningLotto);
        outputView.printLottoResult(new LottoResultResponse(lottoResults));
    }
}
