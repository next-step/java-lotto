package step3;

import step3.generator.AutoLottoGenerator;
import step3.model.Lotto;
import step3.model.LottoNumber;
import step3.view.InputView;
import step3.view.ResultView;

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
