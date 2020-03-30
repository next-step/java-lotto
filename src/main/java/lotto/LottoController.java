package lotto;

public class LottoController {

    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int purchaseCount = inputView.getPurchaseCount();
        System.out.println(purchaseCount + "를 구매 했습니다.");

        LottoGenerator lottoGenerator = new LottoGenerator(purchaseCount);
        lottoGenerator.createLottoNumbersByPurchaseCount();
        LottoTicket lottoTicket = lottoGenerator.getLottoTicket();

        String printPurchaseLottoNumbers = resultView.printPurchaseLottoNumbers(lottoTicket);
        System.out.println(printPurchaseLottoNumbers);

        resultView = new ResultView(lottoTicket);
        System.out.println(resultView.printWinningResult());
        System.out.println(resultView.printRevenuePercent());

    }
}
