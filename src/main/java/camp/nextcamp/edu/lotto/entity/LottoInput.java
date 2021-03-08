package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.util.StringUtils.*;

public class LottoInput {
	private static final int PRICE = 1000;
	private final int lottoTicketCount;

	public LottoInput(String money) {
		if (!isNumeric(money)) {
			throw new RuntimeException("숫자만 가능합니다.");
		}

		this.lottoTicketCount = makeTicket(Integer.parseInt(money));
	}

	private int makeTicket(int money) {
		return money / PRICE;
	}

	public int getLottoTicketCount() {
		return this.lottoTicketCount;
	}

}
