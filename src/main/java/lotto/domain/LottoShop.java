package lotto.domain;

public class LottoShop {
	private static final Integer LOTTO_TICKET_PRICE = 1000;

	public int sellTicket(int amount) {
		return amount / LOTTO_TICKET_PRICE;
	}
}
