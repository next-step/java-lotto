package step4;

import step4.generator.DefaultLottoGenerator;
import step4.model.Lotto;
import step4.model.LottoNumber;
import step4.model.Money;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Money money = new Money(inputView.inputMoney());

        int manualLottoCount = inputView.inputManualLottoCount();

        List<Lotto> manualLottos = inputView.inputManualLottoNumbers(manualLottoCount);

        LottoGame lottoGame = new LottoGame(new DefaultLottoGenerator(manualLottos), money);
        resultView.printLottos(lottoGame.getLottos());

        Lotto winLotto = Lotto.ofComma(inputView.inputResult());
        LottoNumber lottoNumber = LottoNumber.of(inputView.inputBonus());
        resultView.printResult(lottoGame.getResult(winLotto, lottoNumber));
    }
}
