package lotto;

public class LottoController {

    private static InputView inputView = InputView.getInputView();
    private static LottoGenerator lottoGenerator = LottoGenerator.getLottoGenerator();
    private static ResultView resultView = ResultView.getResultView();

    public static void main(String[] args) {

        int purchaseCount = inputView.enterPurchaseAmount();
        int manualCount = inputView.enterManualCount(purchaseCount);
        int automaticCount = inputView.getAutomaticCount(purchaseCount, manualCount);

        System.out.println(inputView.purchaseLottoTicketInfo(manualCount, automaticCount));

        LottoTicket manualLottoTicket = lottoGenerator.createManualLottoTicket(manualCount);
        LottoTicket automaticLottoTicket = lottoGenerator.createAutomaticLottoTicket(automaticCount);
        LottoTicket lottoTicket = lottoGenerator.totalLottoTicket(manualLottoTicket,automaticLottoTicket);

        String printPurchaseLottoNumbers = resultView.printPurchaseLottoNumbers(lottoTicket);
        System.out.println(printPurchaseLottoNumbers);

        resultView.setLottoTicket(lottoTicket);
        resultView.enterValue();

        System.out.println(resultView.printWinningResult());
        System.out.println(resultView.printRevenuePercent());

    }
}
