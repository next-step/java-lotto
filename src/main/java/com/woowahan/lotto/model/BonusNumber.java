package com.woowahan.lotto.model;

import com.woowahan.lotto.constant.Message;
import com.woowahan.lotto.util.ValidationUtil;

public class BonusNumber {

	private int bonusNumber;

	public BonusNumber(String bonusNumber) {
		validate(bonusNumber);
		this.bonusNumber = Integer.parseInt(bonusNumber);
	}

	private void validate(String bonusNumber) {
		if (ValidationUtil.isNotNumber(bonusNumber) || ValidationUtil.isWrongNumber(bonusNumber)) {
			throw new IllegalArgumentException(Message.MSG_WRONG_BONUS_NUMBER);
		}
	}

	public static BonusNumber of(String bonusNumber) {
		return new BonusNumber(bonusNumber);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("BonusNumber{");
		sb.append("bonusNumber=").append(bonusNumber);
		sb.append('}');
		return sb.toString();
	}
}
