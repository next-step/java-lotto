import domain.lotto.LottoResult;
import domain.lotto.Lottos;
import domain.lotto.WinningLotto;
import view.InputView;
import view.ResultView;

public class LottoApplication {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		int money = inputView.inputMoney();
		Lottos lottos = new Lottos(money);
		resultView.printLottos(lottos);

		WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers());
		LottoResult result = lottos.result(winningLotto);
		resultView.printResult(result, money);
	}
}

