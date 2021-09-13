import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.Lotto;
import lotto.LottoGame;
import lotto.LottoTicket;
import lotto.Money;
import lotto.WinningNumber;
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
		LottoGame game = new LottoGame();

		Money money = new Money(this.inputView.inputAmountOfMoney());

		List<LottoTicket> manualLottoTickets = game.buyManualLotto(this.inputView.inputManualLottoNumbers(), money);

		List<LottoTicket> lottoTickets = game.buyLotto(money);

		this.inputView.drawLottoNumbers(manualLottoTickets, lottoTickets);

		List<LottoTicket> totalLottos = new ArrayList<>();
		totalLottos.addAll(manualLottoTickets);
		totalLottos.addAll(lottoTickets);
		this.resultView.drawResult(
			game.lottoResult(totalLottos, this.inputView.inputWinningNumbers(), this.inputView.inputBonusNumber()));
	}

	public static void main(String[] args) {
		Application application = new Application();
		application.startLottoGame();
	}
}
