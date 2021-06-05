package study.ascii92der.lotto.step3to5;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);
        ResultView resultView = new ResultView();
        LottoGame lottoGame = new LottoGame(inputView, resultView);

        while (true) {
            lottoGame.run();
        }
    }

}
