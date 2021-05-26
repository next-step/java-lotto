package lotto.domain;

import java.util.List;

public class LottoStore {

	public static final int PRICE = 1000;
	private static final String INVALID_MONEY_MESSAGE = "로또 구입 금액은 %d원 이상입니다.";
	private static final int LOWER_BOUND = 1;

	private static final LottoMachine lottoMachine = new LottoMachine();

	public UserLotto buy(Money money) {
		validate(money);

		return new UserLotto(generateLottoTickets(money));
	}

	private void validate(Money money) {
		if (money == null || lottoGameCount(money) < LOWER_BOUND) {
			throw new IllegalArgumentException(String.format(INVALID_MONEY_MESSAGE, PRICE));
		}
	}

	private int lottoGameCount(Money money) {
		return money.divide(PRICE);
	}

	private List<LottoTicket> generateLottoTickets(Money money) {
		return lottoMachine.generate(lottoGameCount(money));
	}

}
