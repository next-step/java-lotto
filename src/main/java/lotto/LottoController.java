package lotto;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        ResultView resultView = new ResultView();
        int inputPurchaseAmount = inputView.inputPurchaseAmount();
        int lottoCount = purchaseLotto.availablePurchaseLottoCount(inputPurchaseAmount);
        resultView.printPurchasedCount(lottoCount);
        purchaseLotto.purchaseAvailableLotto(lottoCount);
        resultView.printPurchasedLottos(purchaseLotto.getLottoNumberList());
        purchaseLotto.resultLottoGame(inputView.inputLastWonLottoNumbers());
        resultView.printLottoGameResult(purchaseLotto.getResultAll(), inputPurchaseAmount);
    }
}
