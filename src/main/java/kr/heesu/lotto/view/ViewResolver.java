package kr.heesu.lotto.view;

import kr.heesu.lotto.domain.LottoResult;
import kr.heesu.lotto.domain.MultipleLotto;
import kr.heesu.lotto.domain.PurchaseAmount;
import kr.heesu.lotto.domain.WinningNumbers;

public class ViewResolver {
    private final InputView inputView;
    private final ResultView resultView;

    private ViewResolver() {
        this.inputView = InputView.of();
        this.resultView = ResultView.of();
    }

    public PurchaseAmount getPurchaseAmount() {
        return inputView.getPurchaseAmount();
    }

    public WinningNumbers getWinningNumbers() {
        return inputView.getWinningNumbers();
    }

    public static ViewResolver of() {
        return new ViewResolver();
    }

    public void printLottoResult(LottoResult result) {
        resultView.printLottoResult(result);
    }

    public void printMultipleLotto(MultipleLotto multipleLotto) {
        resultView.printMultipleLotto(multipleLotto);
    }

    public void printPurchaseAmount(PurchaseAmount amount) {
        resultView.printPurchaseAmount(amount);
    }
}