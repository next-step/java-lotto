package lotto;

import lotto.domain.LottoBuyingRequest;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.ManualLottoCount;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.Money;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;

public class LottoApplication {

	public static final int NORMAL_SIGNAL = 1;
	public static final int ABNORMAL_SIGNAL = -1;
	public static final String EXCEPTION_OCCURRED_MESSAGE = "Exception occurred. message: %s";

	private final OutputView outputView;
	private final InputView inputView;

	public LottoApplication(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public int run() {
		try {
			process();

			return NORMAL_SIGNAL;
		} catch (Exception e) {
			System.err.printf(EXCEPTION_OCCURRED_MESSAGE, e.getMessage());

			return ABNORMAL_SIGNAL;
		}
	}

	private void process() {
		Money money = inputView.receiveMoney();
		ManualLottoCount manualLottoCount = inputView.receiveManualLottoCount(money);
		ManualLottoNumbers manualLottoNumbers = inputView.receiveManualLottoNumbers(manualLottoCount);

		LottoMachine lottoMachine = new LottoMachine();
		LottoBuyingRequest lottoBuyingRequest = new LottoBuyingRequest(money, manualLottoNumbers);
		UserLotto userLotto = lottoMachine.buy(lottoBuyingRequest);

		outputView.userLottoCountView(lottoBuyingRequest);
		outputView.userLottoNumberListView(userLotto);

		LottoTicket winningLottoTicket = inputView.receiveWinningLottoNumber();
		LottoNumber bonusLottoNumber = inputView.receiveBonusNumber();
		WinningLotto winningLotto = new WinningLotto(winningLottoTicket, bonusLottoNumber);

		outputView.lottoReportView(userLotto.report(winningLotto));
	}

	public static void main(String[] args) {
		UserInterface userInterface = new Console();

		try {
			InputView inputView = new InputView(userInterface);
			OutputView outputView = new OutputView(userInterface);
			LottoApplication lottoApplication = new LottoApplication(inputView, outputView);
			lottoApplication.run();
		} finally {
			userInterface.shutdown();
		}
	}

}
