package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

        final int manualLottoAmount = lottoInputView.inputManualLottoAmount();

        final LottoShop lottoShop = LottoShop.getInstance();
        final int autoLottoAmount = lottoShop.countPossibleLottoAmount(money) - manualLottoAmount;

        final Lottos allLotto = createLottos(manualLottoAmount, lottoShop, autoLottoAmount);

        lottoResultView.printLottos(allLotto, autoLottoAmount, manualLottoAmount);

        final WinningLotto winningLotto = createWinningLotto();
        final LottoGame lottoGame = new LottoGame(allLotto, winningLotto);
        final LottoResults lottoResults = lottoGame.findWinner();
        lottoResultView.finishGame(lottoResults, lottoResults.calculateYield(money));
    }

    private Lottos createLottos(final int manualLottoAmount, final LottoShop lottoShop,
        final int autoLottoAmount) {
        lottoInputView.printMessageInputHandOperatedLottoNumbers();

        Lottos allLotto = Stream.generate(
                () -> lottoShop.buyManualLotto(lottoInputView.inputManualLottoNumbers()))
            .limit(manualLottoAmount)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));

        allLotto.storeAllLottos(lottoShop.buyAutoLottos(autoLottoAmount));

        return allLotto;
    }

    private WinningLotto createWinningLotto() {
        final List<LottoNumber> winningNumbers = createWinningNumbers();
        final LottoNumber bonusBall = new LottoNumber(lottoInputView.inputBonusBall());
        return new WinningLotto(new Lotto(winningNumbers), bonusBall);
    }

    private List<LottoNumber> createWinningNumbers() {
        return Arrays.stream(lottoInputView.inputWinningNumber())
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
