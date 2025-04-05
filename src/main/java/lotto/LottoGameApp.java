package lotto;


public class LottoGameApp {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGame lottoGame = new LottoGame();

        int money = inputView.receiveMoney();
        Lotto[] lottos = lottoGame.buyLottos(money);

        inputView.printBoughtLottos(lottos);

        int[] winningLottoNumbers = inputView.receiveWinningLottoNumbers();
        int bonusNumber = inputView.receiveBonusNumber();
        WinningLotto winningLotto = lottoGame.getWinningLotto(winningLottoNumbers, bonusNumber);

        LottoRank [] lottoResults = lottoGame.getResults(lottos, winningLotto);
        outputView.printResult(lottoResults);
    }
}
