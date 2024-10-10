package lotto.step2;

import lotto.step2.domain.*;
import lotto.step2.ui.InputView;
import lotto.step2.ui.ResultView;

public class LottoApplication {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoNumbersGenerater numbersGenerater;

    private LottoResult lottoResult;

    public LottoApplication(final InputView inputView, final ResultView resultView, final LottoNumbersGenerater numbersGenerater) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.numbersGenerater = numbersGenerater;
    }

    public void run(){
        int purchaseAmount = inputView.getPurchaseAmountFromUser();

        int lottoCount = buyLotto(purchaseAmount);
        Lottos lottos = createLottos(resultView, lottoCount);

        WinningNumbers winningNumbers = createWinningNumbers(inputView);

        this.lottoResult = new LottoResult(lottos, winningNumbers);
        showLottoResult(this.lottoResult);
        showLottoProfit(purchaseAmount);
    }

    private int buyLotto(int purchaseAmount){
        LottoMachine machine = new LottoMachine();
        int lottoCount = machine.buyLottos(purchaseAmount);
        resultView.showLottoCount(lottoCount);
        return lottoCount;
    }

    private Lottos createLottos(ResultView resultView, int lottoCount) {
        Lottos lottos = Lottos.create(lottoCount, numbersGenerater);
        resultView.showLottos(lottos);
        return lottos;
    }

    private WinningNumbers createWinningNumbers(InputView inputView) {
        String numbers = inputView.getWinningNumbersFromUser();
        return WinningNumbers.create(numbers);
    }

    private void showLottoResult(LottoResult lottoResult) {
        resultView.showLottoResult(lottoResult);
    }

    private void showLottoProfit(int purchaseAmount){
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        resultView.showLottoProfit(profitRate);
        showProfitStatus(profitRate);
    }

    private void showProfitStatus(double profitRate){
        ProfitStatus status = ProfitStatus.from(profitRate);
        resultView.showProfitStatus(status);
    }
}
