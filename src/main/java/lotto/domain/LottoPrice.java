package lotto.domain;

public class LottoPrice {
	private static final int PRICE_PER_TICKET = 1000;
	private final int purchaseCost;

	public LottoPrice(String amountMoney) {
		this.purchaseCost = Integer.parseInt(amountMoney);
	}

	public int purchaseTicketAmount() {
		isGraterThanTicketPerPrice();
		return this.purchaseCost / PRICE_PER_TICKET;
	}

	private void isGraterThanTicketPerPrice() {
		if (this.purchaseCost < PRICE_PER_TICKET){
			throw new IllegalArgumentException("티켓의 가격보다 구매 가격이 낮습니다.");
		}
	}

	public double totalPrizeMoneyRate(int totalPrizeMoney) {
		return (double) totalPrizeMoney / this.purchaseCost;
	}
}
