package lotto;

import lotto.domain.LottoBuyingRequest;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberText;
import lotto.domain.LottoReport;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketConverter;
import lotto.domain.ManualLottoCount;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.Money;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.function.FillListWithRepeatOperation;

import java.util.Collections;

public class LottoApplication {

	public static final int NORMAL_SIGNAL = 1;
	public static final int ABNORMAL_SIGNAL = -1;
	public static final String EXCEPTION_OCCURRED_MESSAGE = "Exception occurred. message: %s";

	private final LottoView lottoView = new LottoView();
	private final UserInterface userInterface;

	public LottoApplication(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	public int run() {
		try {
			Money money = receiveMoney();
			ManualLottoCount manualLottoCount = receiveManualLottoCount(money);
			ManualLottoNumbers manualLottoNumbers = receiveManualLottoNumbers(manualLottoCount);
			UserLotto userLotto = buyLotto(money, manualLottoNumbers);
			LottoTicket winningLottoTicket = receiveWinningLottoNumber();
			LottoNumber bonusLottoNumber = receiveBonusNumber();
			WinningLotto winningLotto = new WinningLotto(winningLottoTicket, bonusLottoNumber);
			reportLottoResult(userLotto.report(winningLotto));

			return NORMAL_SIGNAL;
		} catch (Exception e) {
			System.err.printf(EXCEPTION_OCCURRED_MESSAGE, e.getMessage());

			return ABNORMAL_SIGNAL;
		} finally {
			userInterface.shutdown();
		}
	}

	private void reportLottoResult(LottoReport lottoReport) {
		sendMessage(lottoView.lottoReportView(lottoReport));
	}

	private LottoNumber receiveBonusNumber() {
		sendMessage(lottoView.inputBonusNumber());

		return LottoNumber.of(userInterface.receive());
	}

	private LottoTicket receiveWinningLottoNumber() {
		sendMessage(lottoView.inputWinningLottoNumbers());

		return LottoTicketConverter.convert(userInterface.receive());
	}

	private UserLotto buyLotto(Money money, ManualLottoNumbers manualLottoNumbers) {
		LottoBuyingRequest lottoBuyingRequest = new LottoBuyingRequest(money, manualLottoNumbers);
		LottoMachine lottoMachine = new LottoMachine();
		UserLotto userLotto = lottoMachine.buy(lottoBuyingRequest);

		sendMessage(lottoView.userLottoCountView(lottoBuyingRequest));
		sendMessage(lottoView.userLottoNumberListView(userLotto));

		return userLotto;
	}

	private ManualLottoNumbers receiveManualLottoNumbers(ManualLottoCount manualLottoCount) {
		sendMessage(lottoView.inputManualLottoNumberView());

		return new ManualLottoNumbers(new FillListWithRepeatOperation<LottoNumberText>()
				.andThen(Collections::unmodifiableList)
				.apply(manualLottoCount.count(),
						() -> new LottoNumberText(userInterface.receive())));
	}

	private ManualLottoCount receiveManualLottoCount(Money money) {
		sendMessage(lottoView.inputManualLottoCountView());

		return new ManualLottoCount(userInterface.receive(), money);
	}

	private Money receiveMoney() {
		sendMessage(lottoView.inputMoneyView());

		return new Money(userInterface.receive());
	}

	private void sendMessage(String message) {
		userInterface.send(message);
	}

	public static void main(String[] args) {
		UserInterface console = new Console();
		LottoApplication lottoApplication = new LottoApplication(console);
		lottoApplication.run();
	}

}
