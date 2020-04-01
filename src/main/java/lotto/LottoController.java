package lotto;

public class LottoController {

    private static InputView inputView = InputView.getInputView();
    private static ResultView resultView = ResultView.getResultView();

    public static void main(String[] args) {

        int purchaseCount = inputView.enterPurchaseAmount();
        int manualCount = inputView.enterManualCount(purchaseCount);
        int automaticCount = inputView.getAutomaticCount(purchaseCount, manualCount);

        System.out.println(inputView.purchaseLottoTicketInfo(manualCount, automaticCount));

        LottoGenerator lottoGenerator = new LottoGenerator(automaticCount, manualCount);
        lottoGenerator.createLottoNumbersByPurchaseCount();
        LottoTicket lottoTicket = lottoGenerator.getLottoTicket();

        String printPurchaseLottoNumbers = resultView.printPurchaseLottoNumbers(lottoTicket);
        System.out.println(printPurchaseLottoNumbers);

        resultView.setLottoTicket(lottoTicket);
        resultView.enterValue();

        System.out.println(resultView.printWinningResult());
        System.out.println(resultView.printRevenuePercent());

    }
}
