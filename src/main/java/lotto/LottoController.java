package lotto;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        ResultView resultView = new ResultView();
        int lottoCount = purchaseLotto.availablePurchaseLottoCount(inputView.inputPurchaseAmount());
        resultView.printPurchasedCount(lottoCount);
        purchaseLotto.purchaseLottos(lottoCount);
        resultView.printPurchasedLottos(purchaseLotto.getLottoNumberList());
        purchaseLotto.checkWinOrLose(inputView.inputLastWonLottoNumbers());
    }
}
