package Lotto;

public class LottoMain {
    public static void main(String[] args){
        InputView inputView = InputView.inputBuyingPrice();
        Lottos lottos = new Lottos();
        lottos.buyLottos(inputView.getBuyAmount());
        ResultBuyView resultBuyView = new ResultBuyView(lottos);
        resultBuyView.printLottos();

        inputView.inputWinInfomation();
        lottos.setWinLotto(inputView.getHitNumbers());
        lottos.setBonusNumber(inputView.getBonusNumber());
        lottos.executeLotto();
        ResultView resultView = new ResultView(lottos);
        resultView.printWinResult();
    }
}
