package lotto.presentation;

import lotto.domain.*;
import lotto.presentation.input.PurchaseAmountInputView;
import lotto.presentation.input.WinningNumberInputView;
import lotto.presentation.output.ChanceOutputView;
import lotto.presentation.output.LottosOutputView;
import lotto.presentation.output.WinningStatisticsOutputView;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    public void execute(){
        int purchaseAmount = inputPurchaseAmount();
        outputPurchaseAmount(purchaseAmount);
        Lottos lottos = executeLottoGame(purchaseAmount);
        outputLottos(lottos);
        List<Integer> lastWeekWinning = getLastWeekWinningNumbers();
        RankingCalculator calculator = new RankingCalculator();
//        calculator.calculate(lastWeekWinning, lottos, );
        WinningStatisticsOutputView outputView = new WinningStatisticsOutputView();
    }

    private int inputPurchaseAmount() {
        PurchaseAmountInputView inputView = new PurchaseAmountInputView();
        return inputView.input();
    }

    private void outputPurchaseAmount(int purchaseAmount) {
        ChanceOutputView outputView = new ChanceOutputView();
        outputView.output(purchaseAmount);
    }

    private Lottos executeLottoGame(int purchaseAmount) {
        LottoService service = new LottoService();
        return service.execute(resolveChance(purchaseAmount), new LottoGenerator());
    }

    private int resolveChance(int purchaseAmount) {
        ChanceResolver resolver = new ChanceResolver();
        return resolver.resolveFromPurchaseAmount(purchaseAmount);
    }

    private void outputLottos(Lottos lottos) {
        LottosOutputView outputView = new LottosOutputView();
        outputView.output(lottos);
    }

    private List<Integer> getLastWeekWinningNumbers() {
        WinningNumberParser parser = new WinningNumberParser();
        return parser.parseToWinningNumbers(inputLastWeekWinningNumbers());
    }

    private String inputLastWeekWinningNumbers() {
        WinningNumberInputView inputView = new WinningNumberInputView();
        String lastWeekWinningNumbers = inputView.input();
        return lastWeekWinningNumbers;
    }

}
