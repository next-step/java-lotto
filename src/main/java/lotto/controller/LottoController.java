package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
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

    public LottoController(final LottoInputView lottoInputView,
        final LottoResultView lottoResultView) {

        this.lottoInputView = lottoInputView;
        this.lottoResultView = lottoResultView;
    }

    public void run() {
        Money money = new Money(lottoInputView.inputPrice());

        final LottoShop lottoShop = LottoShop.getInstance();
        final int lottoAmount = lottoShop.countPossibleLottoAmount(money);

        final LottoGame lottoGame = new LottoGame(lottoShop.buyLotto(lottoAmount));
        final Lottos lottos = lottoGame.getLottos();

        lottoResultView.printLottos(lottos);

        final List<LottoNumber> winningNumbers = collectWinningNumber(lottoInputView.inputWinningNumber());
        final LottoNumber bonusBall = new LottoNumber(lottoInputView.inputBonusBall());

        final WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);

        final Map<Ranking, Integer> totalResult = lottoGame.findWinner(winningLotto, lottos);
        lottoResultView.finishGame(totalResult, money);
    }

    private List<LottoNumber> collectWinningNumber(final String[] winningNumber) {
        return Arrays.stream(winningNumber)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
