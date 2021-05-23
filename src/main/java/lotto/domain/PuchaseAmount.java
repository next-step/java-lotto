package lotto.domain;

public class PuchaseAmount {

	public static final int MINIMUM = 1_000;
	public static final String MESSAGE_WRONG_AMOUNT = "로또를 구입하려면 최소 %,d원 이상 있어야 합니다.";

	private final int purchaseAmount;

	public PuchaseAmount(int purchaseAmount) {
		validationPurchaseAmount(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
	}

	private void validationPurchaseAmount(int purchaseAmount) {
		if (purchaseAmount < MINIMUM) {
			throw new IllegalArgumentException(String.format(MESSAGE_WRONG_AMOUNT, MINIMUM));
		}
	}

	public int findNumberOfAvailablePurchases() {
		return this.purchaseAmount / PuchaseAmount.MINIMUM;
	}
}
