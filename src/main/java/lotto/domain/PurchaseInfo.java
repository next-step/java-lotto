package lotto.domain;

public class PurchaseInfo {
	private final int purchasePrice;
	private final int purchaseManualNumber;

	public PurchaseInfo(int purchasePrice, int purchaseManualNumber) {
		validateManualNumber(purchasePrice, purchaseManualNumber);
		this.purchasePrice = purchasePrice;
		this.purchaseManualNumber = purchaseManualNumber;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getManualPurchaseNumbers() {
		return this.purchaseManualNumber;
	}

	public int calculateAutoPurchasePrice() {
		return this.purchasePrice - (this.purchaseManualNumber * Lotteries.PRICE_PER_GAME);
	}

	public int calculateAutoPurchaseNumbers() {
		return (this.purchasePrice - (this.purchaseManualNumber * Lotteries.PRICE_PER_GAME)) / Lotteries.PRICE_PER_GAME;
	}

	private void validateManualNumber(int purchasePrice, int purchaseManualNumber) {
		int totalPurchaseManualNumber = purchaseManualNumber * Lotteries.PRICE_PER_GAME;
		if (totalPurchaseManualNumber > purchasePrice) {
			throw new IllegalArgumentException("수동으로 구입할 수 있는 금액이 초과했습니다.");
		}
	}
}