package lotto.controller;


import java.util.List;
import java.util.Map;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoResultView lottoResultView;
    private final LottoShop lottoShop;
    private final LottoGame lottoGame;

    public LottoController(final LottoInputView lottoInputView,
        final LottoResultView lottoResultView, final LottoShop lottoShop,
        final LottoGame lottoGame) {

        this.lottoInputView = lottoInputView;
        this.lottoResultView = lottoResultView;
        this.lottoShop = lottoShop;
        this.lottoGame = lottoGame;
    }

    public void run() {
        final int inputPrice = lottoInputView.inputPrice();
        final Lottos lottos = lottoGame.startLotto(inputPrice, lottoShop);

        lottoInputView.printLottos(lottos);

        final List<LottoNumber> winningNumber = lottoInputView.inputWinningNumber();
        final LottoNumber bonusBall = lottoInputView.inputBonusBall();

        final Map<Ranking, Integer> totalResult = lottoGame.findWinner(winningNumber, lottos,
            bonusBall);
        lottoResultView.finishGame(totalResult, inputPrice);
    }
}
