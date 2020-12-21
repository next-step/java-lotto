package lotto;

public class Purchase {
	private static final int MIN_PURCHASE_AMOUNT = 0;

	private final int purchaseAmount;

	private Purchase(int purchaseAmount) {
		validate(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
	}

	public static Purchase of(int purchaseAmount) {
		return new Purchase(purchaseAmount);
	}

	private void validate(int purchaseAmount) {
		if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
			throw new IllegalArgumentException("구매 금액은 0 이상이어야 합니다.");
		}
	}

	public int countBuyableLotto(int price) {
		if (purchaseAmount <= MIN_PURCHASE_AMOUNT) {
			return 0;
		}
		return purchaseAmount / price;
	}
}
