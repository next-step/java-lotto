package lotto;

import lotto.domain.LottoReport;
import lotto.domain.LottoVendor;
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
			sendMessage(lottoView.inputMoneyView());
			UserLotto userLotto = buyLotto(receiveMoney());
			viewUserLottoState(userLotto);

			sendMessage(lottoView.inputWinningLottoNumbers());
			String winningLottoNumbers = winningLottoNumbers();
			sendMessage(lottoView.inputBonusNumber());
			String bonusNumberString = bonusLottoNumber();

			LottoVendor lottoVendor = lottoController.lottoVendor(winningLottoNumbers, bonusNumberString);
			viewUserLottoReport(lottoVendor.report(userLotto.lottoTickets()));

			return NORMAL_SIGNAL;
		} catch (Exception e) {
			System.err.printf(EXCEPTION_OCCURRED_MESSAGE, e.getMessage());

			return ABNORMAL_SIGNAL;
		} finally {
			userInterface.shutdown();
		}
	}

	private void sendMessage(String message) {
		userInterface.send(message);
	}

	private String receiveMoney() {
		return userInterface.receive();
	}

	private UserLotto buyLotto(String money) {
		return lottoController.buyLotto(money);
	}

	private void viewUserLottoReport(LottoReport lottoReport) {
		sendMessage(lottoView.lottoReportView(lottoReport));
	}

	private String winningLottoNumbers() {
		return userInterface.receive();
	}

	private String bonusLottoNumber() {
		return userInterface.receive();
	}

	private void viewUserLottoState(UserLotto userLotto) {
		sendMessage(lottoView.userLottoCountView(userLotto.count()));
		sendMessage(lottoView.userLottoNumberListView(userLotto.lottoNumberMessage()));
	}

	public static void main(String[] args) {
		UserInterface console = new Console();
		LottoApplication lottoApplication = new LottoApplication(console);
		lottoApplication.run();
	}

}
