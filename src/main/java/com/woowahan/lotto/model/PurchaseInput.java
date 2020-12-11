package com.woowahan.lotto.model;

import com.woowahan.lotto.constant.Message;
import com.woowahan.lotto.util.ValidationUtil;

public class PurchaseInput {

	private final int purchaseAmount;

	private PurchaseInput(String purchaseAmount) {
		validate(purchaseAmount);
		this.purchaseAmount = Integer.parseInt(purchaseAmount);
	}

	public static PurchaseInput of(String purchaseAmount) {
		return new PurchaseInput(purchaseAmount);
	}

	private void validate(String value) {
		if (ValidationUtil.isNotNumber(value)
			|| ValidationUtil.isZeroOrNegative(value)
			|| ValidationUtil.existRemainder(Integer.parseInt(value), Lotto.LOTTO_PRICE)) {
			throw new IllegalArgumentException(Message.MSG_WRONG_NUMBER);
		}
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PurchaseInput{");
		sb.append("purchaseAmount=").append(purchaseAmount);
		sb.append('}');
		return sb.toString();
	}
}
