package study.ascii92der.lotto.step3n4;

public class LottoMain {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        while (true) {
            lottoGame.start(InputView.inputMoney(),
                    InputView.inputWinnerNumbers(),
                    InputView.inputBonusNumber());
        }
    }

}
