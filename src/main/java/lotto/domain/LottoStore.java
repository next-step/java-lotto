package lotto.domain;

import java.util.List;

class LottoStore {

	public static final int PRICE = 1000;
	private static final String INVALID_MONEY_MESSAGE = "로또 구입 금액이 유효하지 않습니다.";
	private static final int LOWER_BOUND = 1;

	private static final LottoMachine LOTTO_MACHINE = new LottoMachine();

	UserLotto buy(Money money) {
		validate(money);

		return new UserLotto(generateLottoTickets(money));
	}

	private void validate(Money money) {
		if (money == null || lottoGameCount(money) < LOWER_BOUND) {
			throw new IllegalArgumentException(INVALID_MONEY_MESSAGE);
		}
	}

	private int lottoGameCount(Money money) {
		return money.pay(PRICE);
	}

	private List<LottoTicket> generateLottoTickets(Money money) {
		return LOTTO_MACHINE.generate(lottoGameCount(money));
	}

}
