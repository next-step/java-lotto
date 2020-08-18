package kr.heesu.lotto.view;

import kr.heesu.lotto.domain.LottoStatistics;
import kr.heesu.lotto.domain.Lottos;
import kr.heesu.lotto.domain.PurchaseAmount;

public class ViewResolver {
    private final InputView inputView;
    private final ResultView resultView;

    private ViewResolver() {
        this.inputView = InputView.of();
        this.resultView = ResultView.of();
    }

    public static ViewResolver of() {
        return new ViewResolver();
    }

    public String getPurchaseAmount() {
        System.out.println(ViewMessage.INPUT_FOR_PURCHASE_AMOUNT.getMessage());
        return this.inputView.read();
    }

    public String getWinningNumbers() {
        System.out.println(ViewMessage.INPUT_FOR_WINNING_NUMBERS.getMessage());
        return this.inputView.read();
    }

    public void printLottoStatistics(LottoStatistics result) {
        System.out.println(ViewMessage.OUTPUT_FOR_LOTTO_STATISTICS);
        System.out.println(ViewMessage.OUTPUT_FOR_LINE);

        resultView.printLottoStatistics(result);
    }

    public void printMultipleLotto(Lottos multipleLotto) {
        resultView.printMultipleLotto(multipleLotto);
    }

    public void printPurchaseAmount(PurchaseAmount amount) {
        resultView.printPurchaseAmount(amount);
    }
}