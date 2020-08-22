package kr.heesu.lotto.view;

import kr.heesu.lotto.domain.LottoStatistics;
import kr.heesu.lotto.domain.Lottos;
import kr.heesu.lotto.domain.PurchaseAmount;

public class ViewResolver {
    private final InputView inputView;
    private final ResultView resultView;

    private ViewResolver(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static ViewResolver of() {
        InputView inputView = InputView.getInstance();
        ResultView resultView = ResultView.getInstance();

        return new ViewResolver(inputView, resultView);
    }

    public String getPurchaseAmount() {
        System.out.println(ViewMessage.INPUT_FOR_PURCHASE_AMOUNT.getMessage());
        return this.inputView.read();
    }

    public String getWinningNumbers() {
        System.out.println(ViewMessage.INPUT_FOR_WINNING_NUMBERS.getMessage());
        return this.inputView.read();
    }

    public String getBonusNumbers() {
        System.out.println(ViewMessage.INPUT_FOR_BONUS_NUMBER.getMessage());
        return this.inputView.read();
    }

    public void printLottoStatistics(LottoStatistics result) {
        System.out.println(ViewMessage.OUTPUT_FOR_LOTTO_STATISTICS.getMessage());
        System.out.println(ViewMessage.OUTPUT_FOR_LINE.getMessage());

        resultView.printLottoStatistics(result);
    }

    public void printMultipleLotto(Lottos multipleLotto) {
        resultView.printMultipleLotto(multipleLotto);
    }

    public void printPurchaseAmount(PurchaseAmount amount) {
        resultView.printPurchaseAmount(amount);
    }
}