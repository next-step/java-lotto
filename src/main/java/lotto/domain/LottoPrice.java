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
		return this.manualCount;
	}

	private int getManualAmount() {
		return this.manualCount * PRICE_PER_TICKET;
	}

	public boolean availablePurchaseManualAmount(int nowNumberOfTicket) {
		return nowNumberOfTicket >= this.manualCount;
	}

	public boolean availablePurchaseAutoAmount(int nowNumberOfTicket) {
		return nowNumberOfTicket < getAutoCount();
	}

	public int getAutoCount() {
		return (this.amountMoney / PRICE_PER_TICKET) - this.manualCount;
	}

	private void isGraterThanTicketPerPrice() {
		if (this.amountMoney < PRICE_PER_TICKET) {
			throw new IllegalArgumentException("티켓의 가격보다 구매 가격이 낮습니다.");
		}

		if (this.amountMoney < getManualAmount()) {
			throw new IllegalArgumentException("수동으로 구매 불가능한 개수 입니다.");
		}
	}

	public double totalPrizeMoneyRate(int totalPrizeMoney) {
		return (double) totalPrizeMoney / this.amountMoney;
	}
}
