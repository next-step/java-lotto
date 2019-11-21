package step4;

import step4.generator.AutoLottoGenerator;
import step4.model.Lotto;
import step4.model.LottoNumber;
import step4.view.InputView;
import step4.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.inputMoney();
        LottoGame lottoGame = new LottoGame(new AutoLottoGenerator(), money);
        resultView.printLottos(lottoGame.getLottos());

        Lotto winLotto = Lotto.ofComma(inputView.inputResult());
        LottoNumber lottoNumber = LottoNumber.of(inputView.inputBonus());
        resultView.printResult(lottoGame.getResult(winLotto, lottoNumber));
    }
}
