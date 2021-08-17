package lotto.presentation;

import lotto.common.LottoTicketsParser;
import lotto.domain.LottoResults;
import lotto.common.LottoTicketParser;
import lotto.domain.*;
import lotto.presentation.input.*;
import lotto.presentation.output.ChanceOutputView;
import lotto.presentation.output.EarningRateOutputView;
import lotto.presentation.output.LottosOutputView;
import lotto.presentation.output.WinningStatisticsOutputView;
import lotto.service.LottoService;
import lotto.service.RankingService;

import java.util.List;

public class LottoController {

    public void execute(){
        Money purchaseAmount = inputPurchaseAmount();
        Chance manualChance = inputManualChance();
        LottoTickets manualLottoTickets = inputManualLottoTickets(manualChance);
        Chance autoChance = resolveAutoChance(purchaseAmount, manualChance);
        outputChance(manualChance, autoChance);
        LottoTickets autoLottoTickets = executeAuto(autoChance);
        LottoTickets totalLottoTickets = manualLottoTickets.mergeWith(autoLottoTickets);
        outputLottos(totalLottoTickets);
        LottoResults lottoResults = calculateAndGetLottoResults(totalLottoTickets);
        outputLottoResults(lottoResults);
        outputEarningRate(purchaseAmount, lottoResults);
    }

    private LottoTickets inputManualLottoTickets(Chance manualChance) {
        ManualLottoTicketInputView inputView = new ManualLottoTicketInputView();
        LottoTicketsParser parser = new LottoTicketsParser();
        return parser.parse(inputView.input(manualChance));
    }

    private Chance inputManualChance() {
        ManualChanceInputView inputView = new ManualChanceInputView();
        return inputView.input();
    }

    private LottoResults calculateAndGetLottoResults(LottoTickets lottoTickets) {
        RankingService rankingService = new RankingService();
        return rankingService.calculateResults(getLastWeekWinningNumbers(), lottoTickets, new RankingCalculator());
    }

    private void outputLottoResults(LottoResults lottoResults) {
        WinningStatisticsOutputView outputView = new WinningStatisticsOutputView();
        outputView.output(lottoResults);
    }

    private Money inputPurchaseAmount() {
        PurchaseAmountInputView inputView = new PurchaseAmountInputView();
        return new Money(inputView.input());
    }

    private void outputChance(Chance manualChance, Chance autoChance) {
        ChanceOutputView outputView = new ChanceOutputView();
        outputView.output(manualChance, autoChance);
    }

    private LottoTickets executeAuto(Chance chance) {
        LottoService service = new LottoService();
        return service.execute(chance, new LottoGenerator());
    }

    private Chance resolveAutoChance(Money purchaseAmount, Chance manualChance) {
        ChanceResolver resolver = new ChanceResolver();
        Chance totalChance = resolver.resolveFromPurchaseAmount(purchaseAmount);
        if (!totalChance.isBiggerOrEqualThan(manualChance)) {
            throw new IllegalStateException("수동 입력 횟수가 전체 실행 횟수보다 클 수 없습니다.");
        }
        return totalChance.subtract(manualChance);
    }

    private void outputLottos(LottoTickets lottoTickets) {
        LottosOutputView outputView = new LottosOutputView();
        outputView.output(lottoTickets);
    }

    private WinningNumbers getLastWeekWinningNumbers() {
        LottoTicketParser parser = new LottoTicketParser();
        return new WinningNumbers(
                parser.parse(inputWinningNumbers()), inputBonusNumber());
    }

    private String inputWinningNumbers() {
        WinningNumberInputView inputView = new WinningNumberInputView();
        return inputView.input();
    }

    private LottoNumber inputBonusNumber() {
        BonusNumberInputView inputView = new BonusNumberInputView();
        return inputView.input();
    }

    private void outputEarningRate(Money purchaseAmount, LottoResults lottoResults) {
        EarningRateOutputView outputView = new EarningRateOutputView();
        outputView.output(lottoResults.getEarningLate(purchaseAmount));
    }
}
