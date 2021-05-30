package lotto;

import java.util.Collections;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberText;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketConverter;
import lotto.domain.ManualLottoCount;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.Money;
import lotto.function.FillListWithRepeatOperation;

public class InputView {

	public static final String INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
	public static final String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	public static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

	private final UserInterface userInterface;

	public InputView(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	public Money receiveMoney() {
		userInterface.send(INPUT_MONEY_MESSAGE);

		return new Money(userInterface.receive());
	}

	public ManualLottoCount receiveManualLottoCount(Money money) {
		userInterface.send(INPUT_MANUAL_LOTTO_MESSAGE);

		return new ManualLottoCount(userInterface.receive(), money);
	}

	public ManualLottoNumbers receiveManualLottoNumbers(ManualLottoCount manualLottoCount) {
		userInterface.send(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE);

		return new ManualLottoNumbers(new FillListWithRepeatOperation<LottoNumberText>()
			.andThen(Collections::unmodifiableList)
			.apply(manualLottoCount.count(),
				() -> new LottoNumberText(userInterface.receive())));
	}

	public LottoTicket receiveWinningLottoNumber() {
		userInterface.send(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);

		return LottoTicketConverter.convert(userInterface.receive());
	}

	public LottoNumber receiveBonusNumber() {
		userInterface.send(INPUT_BONUS_NUMBER_MESSAGE);

		return LottoNumber.of(userInterface.receive());
	}

}
