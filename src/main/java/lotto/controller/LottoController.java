package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;


public class LottoController {

    public void buyLotto() {

        int lottoFee = InputView.inputPaymentForGames();
        int manualGameCount = InputView.inputManualGameCount();
        List<List<Integer>> manualLottos = InputView.inputManualGameNumber(manualGameCount);

        LottoShop lottoShop = new LottoShop(LottoFee.from(lottoFee));
        Lottos lottos = lottoShop.buy(manualLottos);

        ResultView.showPurchaseQuantitiy(manualGameCount, lottoShop.totalCount());
        ResultView.showLottos(lottos);

        Lotto winningNumber = Lotto.create(InputView.inputWinningNumber());
        LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusNumber());

        WinningLotto winningLottoNumber = new WinningLotto(winningNumber, bonusNumber);
        ResultView.showRanks(lottos.match(winningLottoNumber), lottoShop.fee());

    }
}
