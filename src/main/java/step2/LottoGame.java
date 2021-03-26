package step2;

public class LottoGame {

    private InputView inputView;
    private ResultView resultView;

    public LottoGame(){
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void start(){
        PurchaseManager purchaseManager = new PurchaseManager(inputView.buyLotto());
        resultView.printPurchaseNumber(purchaseManager);
        resultView.printLottoList(purchaseManager);
    }
}
