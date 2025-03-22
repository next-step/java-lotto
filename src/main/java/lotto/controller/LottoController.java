package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoShop;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {

    private final LottoInputView inputView = new LottoInputView();
    private final LottoResultView resultView = new LottoResultView();

    public void run() {
        int money = inputView.getMoney();

        LottoShop lottoShop = new LottoShop();
        List<Lotto> lottos = lottoShop.buy(money);

        resultView.printPurchaseLotto(lottos);

        List<LottoNumber> winningLottoNumbers = inputView.getWinningLotto()
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto, lottos);
        resultView.printStatistics(money, lottoStatistics);
    }

}
