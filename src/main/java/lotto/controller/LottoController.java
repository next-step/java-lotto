package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinnerLotto;
import lotto.service.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        LottoGame game = LottoGame.getInstance();
        int lottoPrice = inputView.getLottoPrice();

        final int manualLottoCount = inputView.getManualLottoCount();

        game.validateBuy(lottoPrice, manualLottoCount);
        Lottos manualLottos = inputView.getManualLottos(manualLottoCount);
        lottoPrice = game.buyManual(lottoPrice, manualLottoCount);
        Lottos autoLottos = game.buyAuto(lottoPrice);

        Lottos total = Lottos.of(manualLottos, autoLottos);

        resultView.priceLottoStatus(autoLottos, manualLottos);
        String lastWinningNumber = inputView.getLastWinningNumber();
        Lotto winnerLotto = inputView.getLottoNumbers(lastWinningNumber);
        LottoNum bonusNumber = inputView.getBonusNumber();

        LottoResult result = LottoResult.getLottoResult(total, new WinnerLotto(winnerLotto, bonusNumber));

        resultView.printLottoResult(result);
    }
}
