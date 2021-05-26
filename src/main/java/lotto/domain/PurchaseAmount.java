package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {

	public static final int MINIMUM = 1_000;
	public static final String MESSAGE_INVALID_MINIMUM_AMOUNT = "로또를 구입하려면 최소 %,d원 이상 있어야 합니다.";
	public static final String MESSAGE_INVALID_AMOUNT = "구입금액은 숫자(정수)만 입력가능합니다.";

	private final int purchaseAmount;

	public PurchaseAmount(String purchaseAmount) {
		validationNumber(purchaseAmount);
		validationMinimum(purchaseAmount);
		this.purchaseAmount = Integer.parseInt(purchaseAmount);
	}

	public PurchaseAmount(int purchaseAmount) {
		validationMinimum(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
	}

	public int findNumberOfAvailablePurchases() {
		return this.purchaseAmount / MINIMUM;
	}

	private void validationNumber(String purchaseAmount) {
		if (!isNumeric(purchaseAmount)) {
			throw new IllegalArgumentException(MESSAGE_INVALID_AMOUNT);
		}
	}

	private void validationMinimum(String purchaseAmount) {
		validationMinimum(Integer.parseInt(purchaseAmount));
	}

	private void validationMinimum(int purchaseAmount) {
		if (purchaseAmount < MINIMUM) {
			throw new IllegalArgumentException(String.format(MESSAGE_INVALID_MINIMUM_AMOUNT, MINIMUM));
		}
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

	protected static boolean isNumeric(String str) {
		if (str == null || str.trim().length() == 0) {
			return false;
		}
		String regex = "[0-9]+";
		return str.matches(regex);
	}
}
