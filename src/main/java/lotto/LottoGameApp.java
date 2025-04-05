package lotto;


public class LottoGameApp {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        Lotto[] lottos = lottoGame.buyLottos(InputView.receiveMoney());
        OutputView.printBoughtLottos(lottos);

        WinningLotto winningLotto = lottoGame.getWinningLotto(
                InputView.receiveWinningLottoNumbers(),
                InputView.receiveBonusNumber()
        );

        LottoRank [] lottoResults = lottoGame.getResults(lottos, winningLotto);
        OutputView.printResult(lottoResults);
    }
}
