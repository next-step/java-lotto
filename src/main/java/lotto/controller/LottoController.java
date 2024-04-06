package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

import static lotto.domain.LottoFee.validateManualGameCount;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void buyLotto() {

        LottoFee lottoFee = InputView.inputPaymentForGames();
        int manualGameCount = InputView.inputManualGameCount();

        if (lottoService.validateManualGameCount(manualGameCount, lottoFee.totalCount())) {
            List<List<Integer>> manualLottos = InputView.inputManualGameNumber(manualGameCount);
            Lottos lottos = LottoGenerator.generateLottos(lottoFee, manualLottos);

            ResultView.showPurchaseQuantitiy(manualGameCount, lottoFee);
            ResultView.showLottos(lottos);

            Lotto winningNumber = Lotto.create(InputView.inputWinningNumber());
            LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusNumber());
            WinningLotto winningLottoNumber = new WinningLotto(winningNumber, bonusNumber);

            ResultView.showRanks(lottos.match(winningLottoNumber), lottoFee);
        }
    }
}
