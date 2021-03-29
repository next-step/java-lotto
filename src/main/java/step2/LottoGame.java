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
        Lottos lottos = Lottos.of(new RandomLottoNumberGenerator(purchaseManager));
        resultView.printPurchaseNumber(purchaseManager);
        resultView.printLottoList(lottos);
        resultView.printLottoStatistic(lottos,inputView.winningLotto(),purchaseManager);
    }
}
