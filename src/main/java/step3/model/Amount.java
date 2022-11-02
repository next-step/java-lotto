package step3.model;

import step3.exception.BadRequestException;

public class Amount {

	private static final int LOTTE_PRICE = 1000;

	private final int purchase;

	public Amount(int purchase) {
		checkPurchase(purchase);
		this.purchase = purchase;
	}

	public int getLottoCount() {
		return purchase / LOTTE_PRICE;
	}

	public double getYield(double prize) {
		return Math.floor(prize / purchase * 100) / 100;
	}

	public void checkPurchase(int amount) {
		if (amount < LOTTE_PRICE){
			throw new BadRequestException("입력가능한 최소 구매 금액은 1000 입니다.");
		}
	}
}
