import java.util.List;

import lotto.LottoGame;
import lotto.LottoTicket;
import ui.InputView;
import ui.ResultView;

public class Application {

	private final InputView inputView;
	private final ResultView resultView;

	public Application() {
		this.inputView = new InputView();
		this.resultView = new ResultView();
	}

	public void startLottoGame() {
		LottoGame game = LottoGame.of(1000, 1, 45, 6);

		this.inputView.drawQuestionOfMoney();
		List<LottoTicket> lottoTickets = game.buyLotto(this.inputView.inputAmountOfMoney());

		this.inputView.drawLottoNumbers(lottoTickets);
		this.inputView.drawQuestionOf1stLotto();
		String winningNumbers = this.inputView.inputLottoNumbers();

		this.resultView.drawResult(game.lottoResult(lottoTickets, winningNumbers));
	}

	public static void main(String[] args) {
		Application application = new Application();
		application.startLottoGame();
	}
}
