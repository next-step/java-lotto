package cc.oakk.lotto.controller;

import cc.oakk.lotto.model.*;
import cc.oakk.lotto.util.ValidationAdapters;
import cc.oakk.lotto.view.InputView;
import cc.oakk.lotto.view.ResultView;

import java.util.List;

import static cc.oakk.lotto.util.ValidationAdapters.tryUntilSuccess;

public class LottoGame {
    private final LottoGenerator generator;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(LottoGenerator generator, InputView inputView, ResultView resultView) {
        this.generator = generator;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        int lottoPrice = LottoGenerator.LOTTO_PRICE;
        Money money = getMoney();
        int manualLottoCount = getManualLottoCount(money, lottoPrice);

        Lottos lottos = generator.generateLottos(money);
        readManualLottos(manualLottoCount, lottos);

        resultView.repeatPurchasedLottoCount(lottos.size(), manualLottoCount);
        resultView.printLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        WinningLotto winningLotto = getWinningLotto(winningNumbers);

        LottoResults results = lottos.getResults(winningLotto);
        resultView.printLottoResults(results);
    }

    private WinningLotto getWinningLotto(List<Integer> winningNumbers) {
        return tryUntilSuccess(() -> new WinningLotto(winningNumbers, inputView.readBonusNumber()),
                inputView::printError);
    }

    private List<Integer> getWinningNumbers() {
        inputView.printWinningNumberInputHeader();
        return tryUntilSuccess(inputView::readNumbers, inputView::printError);
    }

    private void readManualLottos(int manualLottoCount, Lottos lottos) {
        inputView.printManualLottoNumbersInputHeader();
        for (int i = 0; i < manualLottoCount; i++) {
            Lotto lotto = tryUntilSuccess(() -> new Lotto(inputView.readNumbers()), inputView::printError);
            lottos.add(lotto);
        }
    }

    private int getManualLottoCount(Money money, int lottoPrice) {
        return tryUntilSuccess(() -> {
            int count = inputView.readManualLottoCount();
            int moneyAfterPurchase = money.get() - count * lottoPrice;
            ValidationAdapters.throwIfNegative(moneyAfterPurchase, "입력하신 금액 보다 더 많이 구매하실 수 없습니다.");
            money.purchase(lottoPrice * count);
            return count;
        }, inputView::printError);
    }

    private Money getMoney() {
        return tryUntilSuccess(() -> new Money(inputView.readMoney()), inputView::printError);
    }
}
