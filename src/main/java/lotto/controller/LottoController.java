package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
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

        Lottos lottos = lottoShop.buyLotto(lottoAmount);
        lottoResultView.printLottos(lottos);

        final List<LottoNumber> winningNumbers = createWinningNumbers();
        final LottoNumber bonusBall = new LottoNumber(lottoInputView.inputBonusBall());
        final WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusBall);
        final LottoGame lottoGame = new LottoGame(lottos, winningLotto);
        final Map<Ranking, Integer> totalResult = lottoGame.findWinner();
        lottoResultView.finishGame(totalResult, money);
    }

    private List<LottoNumber> createWinningNumbers() {
        return Arrays.stream(lottoInputView.inputWinningNumber())
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
