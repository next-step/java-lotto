package lotto.presentation;

import lotto.domain.LottoResults;
import lotto.common.WinningNumberParser;
import lotto.domain.*;
import lotto.presentation.input.BonusNumberInputView;
import lotto.presentation.input.PurchaseAmountInputView;
import lotto.presentation.input.WinningNumberInputView;
import lotto.presentation.output.ChanceOutputView;
import lotto.presentation.output.EarningRateOutputView;
import lotto.presentation.output.LottosOutputView;
import lotto.presentation.output.WinningStatisticsOutputView;
import lotto.service.LottoService;
import lotto.service.RankingService;

public class LottoController {

    public void execute(){
        int purchaseAmount = inputPurchaseAmount();
        int chance = resolveChance(purchaseAmount);
        outputChance(chance);
        LottoTickets lottoTickets = executeLottoGame(chance);
        outputLottos(lottoTickets);
        LottoResults lottoResults = calculateAndGetLottoResults(lottoTickets);
        outputLottoResults(lottoResults);
        outputEarningRate(purchaseAmount, lottoResults);
    }

    private LottoResults calculateAndGetLottoResults(LottoTickets lottoTickets) {
        RankingService rankingService = new RankingService();
        return rankingService.calculateResults(getLastWeekWinningNumbers(), lottoTickets, new RankingCalculator());
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

    private LottoTickets executeLottoGame(int chance) {
        LottoService service = new LottoService();
        return service.execute(chance, new LottoGenerator());
    }

    private int resolveChance(int purchaseAmount) {
        ChanceResolver resolver = new ChanceResolver();
        return resolver.resolveFromPurchaseAmount(purchaseAmount);
    }

    private void outputLottos(LottoTickets lottoTickets) {
        LottosOutputView outputView = new LottosOutputView();
        outputView.output(lottoTickets);
    }

    private WinningNumbers getLastWeekWinningNumbers() {
        WinningNumberParser parser = new WinningNumberParser();
        return new WinningNumbers(parser.parseToWinningNumbers(inputWinningNumbers()), inputBonusNumber());
    }

    private String inputWinningNumbers() {
        WinningNumberInputView inputView = new WinningNumberInputView();
        return inputView.input();
    }

    private LottoNumber inputBonusNumber() {
        BonusNumberInputView inputView = new BonusNumberInputView();
        return inputView.input();
    }

    private void outputEarningRate(int purchaseAmount, LottoResults lottoResults) {
        EarningRateOutputView outputView = new EarningRateOutputView();
        outputView.output(lottoResults.getEarningLate(purchaseAmount));
    }
}
