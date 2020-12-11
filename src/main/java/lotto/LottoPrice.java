package lotto;

public class LottoPrice {
	private static final int PRICE_PER_TICKET = 1000;
	private final int purchaseCost;

	public LottoPrice(String amountMoney) {
		this.purchaseCost = Integer.parseInt(amountMoney);
	}

	public int purchaseTicketAmount() {
		return this.purchaseCost / PRICE_PER_TICKET;
	}

	public int purchaseCost() {
		return purchaseCost;
	}
}
