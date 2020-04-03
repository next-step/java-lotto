package lotto;

import java.util.Map;

public class LottoController {

    private static InputView inputView = InputView.getInputView();
    private static LottoGenerator lottoGenerator = LottoGenerator.getLottoGenerator();
    private static WinningLottoInfo winningLottoInfo = WinningLottoInfo.getWinningLottoInfo();
    private static ResultView resultView = ResultView.getResultView();

    public static void main(String[] args) {

        int purchaseCount = inputView.enterPurchaseAmount();
        int manualCount = inputView.enterManualCount(purchaseCount);
        int automaticCount = inputView.getAutomaticCount(purchaseCount, manualCount);

        resultView.printResult(resultView.purchaseLottoTicketInfo(manualCount, automaticCount));

        LottoTicket manualLottoTicket = lottoGenerator.createManualLottoTicket(manualCount);
        LottoTicket automaticLottoTicket = lottoGenerator.createAutomaticLottoTicket(automaticCount);
        LottoTicket lottoTicket = lottoGenerator.totalLottoTicket(manualLottoTicket, automaticLottoTicket);

        resultView.printResult(lottoTicket.purchaseLottoNumbers());

        winningLottoInfo.enterWinningNumbers();
        winningLottoInfo.enterBonusBall();

        Map<String, WinningLotto> winningLottos = resultView.getWinningLottos(winningLottoInfo, lottoTicket);

        resultView.printResult(resultView.winningResult(winningLottos));
        resultView.printResult(resultView.revenuePercent(winningLottos, lottoTicket));

    }
}
