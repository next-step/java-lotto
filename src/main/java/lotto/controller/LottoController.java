package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResults;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Money;
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
        final Money money = new Money(lottoInputView.inputPrice());

        final int handOperatedLottoAmount = lottoInputView.inputHandOperatedLottoAmount();

        final LottoShop lottoShop = LottoShop.getInstance();
        final int autoLottoAmount = lottoShop.countPossibleLottoAmount(money) - handOperatedLottoAmount;

        final List<Lotto> lottos = new ArrayList<>();
        final Lottos allLotto = new Lottos(lottos);

        purchaseAllLottos(handOperatedLottoAmount, lottoShop, autoLottoAmount, allLotto);

        lottoResultView.printLottos(allLotto, autoLottoAmount, handOperatedLottoAmount);

        final List<LottoNumber> winningNumbers = createWinningNumbers();
        final LottoNumber bonusBall = new LottoNumber(lottoInputView.inputBonusBall());
        final WinningLotto winningLotto = new WinningLotto(Lotto.handOperatedLotto(winningNumbers), bonusBall);
        final LottoGame lottoGame = new LottoGame(allLotto, winningLotto);
        final LottoResults lottoResults = lottoGame.findWinner();
        lottoResultView.finishGame(lottoResults, lottoResults.calculateYield(money));
    }

    private void purchaseAllLottos(final int handOperatedLottoAmount, final LottoShop lottoShop,
        final int autoLottoAmount, final Lottos allLotto) {
        for (int amount = 0; amount < handOperatedLottoAmount; amount++) {
            lottoShop.buyHandOperatedLotto(allLotto,
                lottoInputView.inputHandOperatedLottoNumbers());
        }
        lottoShop.buyAutoLotto(allLotto, autoLottoAmount);
    }

    private List<LottoNumber> createWinningNumbers() {
        return Arrays.stream(lottoInputView.inputWinningNumber())
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
