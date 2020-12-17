package lotto;

public class Purchase {
	private final int purchaseAmount;

	private Purchase(int purchaseAmount) {
		validate(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
	}

	public static Purchase of(int purchaseAmount) {
		return new Purchase(purchaseAmount);
	}

	private void validate(int purchaseAmount) {
		if (purchaseAmount < 0) {
			throw new IllegalArgumentException("구매 금액은 0 이상이어야 합니다.");
		}
	}

	public int getBuyableCount(int price) {
		if (purchaseAmount <= 0) {
			return 0;
		}
		return purchaseAmount / price;
	}
}
