package study.lotto;

public class Play {

    public static void main(String[] args) throws IllegalAccessException {
        LottoGame lottoGame = new LottoGame();
        InputView inputView = new InputView(lottoGame);
        inputView.purchase();
        inputView.draw();

        ResultView resultView = new ResultView(lottoGame);
        resultView.winningResult();
    }
}
