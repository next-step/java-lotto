package lotto;


public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new InputView(), new ResultView());
        lottoGame.run();
    }
}
