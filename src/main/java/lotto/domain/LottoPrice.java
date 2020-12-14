package lotto.domain;

public class LottoPrice {
	private static final int PRICE_PER_TICKET = 1000;
	private final int amountMoney;
	private final int manualCount;

	public LottoPrice(String amountMoney, String manualCount) {
		this.amountMoney = Integer.parseInt(amountMoney);
		this.manualCount = Integer.parseInt(manualCount);
		isGraterThanTicketPerPrice();
	}

	public int getManualCount() {
		return manualCount;
	}

	public boolean availablePurchaseManualAmount() {
		return amountMoney < getManualPurchaseAmount();
	}

	public int availablePurchaseAutoAmount() {
		return getAutoPurchaseAmount() / PRICE_PER_TICKET;
	}

	private int getAutoPurchaseAmount() {
		return this.amountMoney - getManualPurchaseAmount();
	}

	private int getManualPurchaseAmount() {
		return this.manualCount * PRICE_PER_TICKET;
	}


	private void isGraterThanTicketPerPrice() {
		if (this.amountMoney < PRICE_PER_TICKET) {
			throw new IllegalArgumentException("티켓의 가격보다 구매 가격이 낮습니다.");
		}
	}

	public double totalPrizeMoneyRate(int totalPrizeMoney) {
		return (double) totalPrizeMoney / this.amountMoney;
	}
}
