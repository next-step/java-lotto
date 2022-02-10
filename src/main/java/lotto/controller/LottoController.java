package lotto.controller;


import java.util.Map;
import lotto.domain.LottoGame;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoResultView lottoResultView;
    private final LottoShop lottoShop = LottoShop.getInstance();
    private final LottoGame lottoGame = new LottoGame();

    public LottoController(final LottoInputView lottoInputView, final LottoResultView lottoResultView) {

        this.lottoInputView = lottoInputView;
        this.lottoResultView = lottoResultView;
    }

    public void run() {
        Money money = new Money(lottoInputView.inputPrice());
        final Lottos lottos = lottoGame.startLotto(money, lottoShop);

        lottoResultView.printLottos(lottos);

        final WinningLotto winningLotto = new WinningLotto(lottoInputView.inputWinningNumber(),
            lottoInputView.inputBonusBall());

        final Map<Ranking, Integer> totalResult = lottoGame.findWinner(winningLotto, lottos);
        lottoResultView.finishGame(totalResult, money);
    }
}
