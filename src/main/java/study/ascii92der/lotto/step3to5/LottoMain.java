package study.ascii92der.lotto.step3to5;

public class LottoMain {

    public static void main(String[] args) {
        LottoInput lottoInput = new InputView(System.in);
        LottoOutput lottoOutput = new ResultView();
        LottoGame lottoGame = new LottoGame(lottoInput, lottoOutput);

        while (true) {
            lottoGame.run();
        }
    }

}
