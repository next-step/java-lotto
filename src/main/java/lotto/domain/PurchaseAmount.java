package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {

	public static final int AMOUNT_PER_UNIT = 1_000;
	public static final String MESSAGE_INVALID_MINIMUM_AMOUNT = "로또를 구입하려면 최소 %,d원 이상 있어야 합니다.";

	private final int purchaseAmount;


	public PurchaseAmount(int purchaseAmount) {
		validationMinimum(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
	}

	public int availablePurchasesQuantity() {
		return this.purchaseAmount / AMOUNT_PER_UNIT;
	}

	public int availablePurchasesQuantityMinusManualQuantity(int manualQuantity) {
		return (this.purchaseAmount / AMOUNT_PER_UNIT) - manualQuantity;
	}

	private void validationMinimum(int purchaseAmount) {
		if (purchaseAmount < AMOUNT_PER_UNIT) {
			throw new IllegalArgumentException(String.format(MESSAGE_INVALID_MINIMUM_AMOUNT, AMOUNT_PER_UNIT));
		}
	}

	public boolean isGreaterThen(int purchaseAmount) {
		return this.purchaseAmount >= purchaseAmount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PurchaseAmount that = (PurchaseAmount) o;
		return purchaseAmount == that.purchaseAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchaseAmount);
	}

	@Override
	public String toString() {
		return String.valueOf(purchaseAmount);
	}

}
