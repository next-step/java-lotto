package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.constants.LottoConstants.*;
import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;
import static camp.nextcamp.edu.util.StringUtils.*;

import java.util.List;

import camp.nextcamp.edu.lotto.exception.UserException;

public class LottoStore {
	private final int totalMoney;
	private final PurchasedLotto purchasedLotto;

	public LottoStore(String money, List<String> lottoInputs) {

		validateNumericMoney(money);
		this.totalMoney = Integer.parseInt(money);

		ManualLottoTicket manualLottoTicket = new ManualLottoTicket(lottoInputs, getTotalLottoCount());
		LottoTicket lottoTicket = new LottoTicket(getRandomLottoCount(manualLottoTicket));

		this.purchasedLotto = new PurchasedLotto(manualLottoTicket, lottoTicket);
	}

	private void validateNumericMoney(String money) {
		if (!isNumeric(money)) {
			throw new UserException(ONLY_NUMBER);
		}
	}

	private int getTotalLottoCount() {
		return this.totalMoney / LOTTO_MONEY;
	}

	private int getRandomLottoCount(ManualLottoTicket manualLottoTicket) {
		return getTotalLottoCount() - manualLottoTicket.getTicketCount();
	}

	public PurchasedLotto getPurchasedLotto() {
		return purchasedLotto;
	}

	public int getTotalMoney() {
		return this.totalMoney;
	}
}
