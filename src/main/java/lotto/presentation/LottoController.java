package lotto.presentation;

import lotto.common.LottoResults;
import lotto.common.WinningNumberParser;
import lotto.domain.*;
import lotto.presentation.input.PurchaseAmountInputView;
import lotto.presentation.input.WinningNumberInputView;
import lotto.presentation.output.ChanceOutputView;
import lotto.presentation.output.EarningRateOutputView;
import lotto.presentation.output.LottosOutputView;
import lotto.presentation.output.WinningStatisticsOutputView;
import lotto.service.LottoService;
import lotto.service.RankingService;

import java.util.List;

public class LottoController {

    public void execute(){
        int purchaseAmount = inputPurchaseAmount();
        int chance = resolveChance(purchaseAmount);
        outputChance(chance);
        Lottos lottos = executeLottoGame(chance);
        outputLottos(lottos);
        LottoResults lottoResults = calculateAndGetLottoResults(lottos);
        outputLottoResults(lottoResults);
        outputEarningRate(purchaseAmount, lottoResults);
    }

    private LottoResults calculateAndGetLottoResults(Lottos lottos) {
        RankingService rankingService = new RankingService();
        return rankingService.calculateMatchHits(getLastWeekWinningNumbers(), lottos, new RankingCalculator());
    }

    private void outputLottoResults(LottoResults lottoResults) {
        WinningStatisticsOutputView outputView = new WinningStatisticsOutputView();
        outputView.output(lottoResults);
    }

    private int inputPurchaseAmount() {
        PurchaseAmountInputView inputView = new PurchaseAmountInputView();
        return inputView.input();
    }

    private void outputChance(int chance) {
        ChanceOutputView outputView = new ChanceOutputView();
        outputView.output(chance);
    }

    private Lottos executeLottoGame(int chance) {
        LottoService service = new LottoService();
        return service.execute(chance, new LottoGenerator());
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
        return inputView.input();
    }

    private void outputEarningRate(int purchaseAmount, LottoResults lottoResults) {
        EarningRateOutputView outputView = new EarningRateOutputView();
        outputView.output(lottoResults.getEarningLate(purchaseAmount));
    }
}
