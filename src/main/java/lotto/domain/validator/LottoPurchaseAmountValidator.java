package lotto.domain.validator;

import lotto.domain.LottoConstants;
import lotto.domain.common.Money;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by hspark on 07/11/2018.
 */
public enum LottoPurchaseAmountValidator {
	NOT_ENOUGH_AMOUNT(amount -> checkArgument(amount.compareTo(
		LottoConstants.LOTTO_TICKET_AMOUNT) != -1, "로또 구매 금액 이하입니다.")),
	WRONG_AMOUNT(amount -> checkArgument(amount.remainder(LottoConstants.LOTTO_TICKET_AMOUNT).equals(Money.ZERO),
		"1000원 단위로 입력해 주세요."));

	private Validator<Money> validator;

	LottoPurchaseAmountValidator(Validator<Money> validator) {
		this.validator = validator;
	}

	public static void valid(Money amount) {
		Arrays.stream(LottoPurchaseAmountValidator.values()).forEach(validator -> validator.getValidator().valid(amount));
	}

	public Validator<Money> getValidator() {
		return validator;
	}
}
