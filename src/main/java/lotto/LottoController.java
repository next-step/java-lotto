package lotto;

public class LottoController {

    private static InputView inputView = InputView.getInputView();
    private static ResultView resultView = ResultView.getResultView();

    public static void main(String[] args) {

        inputView.enterValue();
        System.out.println(inputView.purchaseLottoTicketInfo());

        LottoGenerator lottoGenerator = new LottoGenerator(inputView.getAutomaticCount(),
                                                           inputView.getManualCount());
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
