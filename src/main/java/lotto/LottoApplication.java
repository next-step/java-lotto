package lotto;

import lotto.domain.LottoReport;
import lotto.domain.UserLotto;

public class LottoApplication {

	public static final int NORMAL_SIGNAL = 1;
	public static final int ABNORMAL_SIGNAL = -1;
	public static final String EXCEPTION_OCCURRED_MESSAGE = "Exception occurred. message: %s";

	private final LottoController lottoController = new LottoController();
	private final LottoView lottoView = new LottoView();
	private final UserInterface userInterface;

	public LottoApplication(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	public int run() {
		try {
			UserLotto userLotto = receiveMoneyAndBuyLotto();
			viewUserLottoState(userLotto);
			viewLottoReport(userLotto);

			return NORMAL_SIGNAL;
		} catch (Exception e) {
			System.err.printf(EXCEPTION_OCCURRED_MESSAGE, e.getMessage());

			return ABNORMAL_SIGNAL;
		} finally {
			userInterface.shutdown();
		}
	}

	private void viewLottoReport(UserLotto userLotto) {
		LottoReport lottoReport = lottoController.report(userInterface.receiveWinningLottoNumber(), userLotto);
		userInterface.send(lottoView.lottoReportView(lottoReport));
	}

	private void viewUserLottoState(UserLotto userLotto) {
		userInterface.send(lottoView.userLottoCountView(userLotto.count()));
		userInterface.send(lottoView.userLottoNumberListView(userLotto.lottoNumberMessage()));
		userInterface.send(lottoView.inputWinningLottoNumbers());
	}

	private UserLotto receiveMoneyAndBuyLotto() {
		userInterface.send(lottoView.inputMoneyView());

		return lottoController.buyLotto(userInterface.receiveMoney());
	}

	public static void main(String[] args) {
		UserInterface console = new Console();
		LottoApplication lottoApplication = new LottoApplication(console);
		lottoApplication.run();
	}

}
