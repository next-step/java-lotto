package lotto.domain.validator;

import lotto.domain.LottoConstants;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by hspark on 07/11/2018.
 */
public enum LottoPurchaseAmountValidator {
	NOT_ENOUGH_AMOUNT(amount -> checkArgument(amount >=
		LottoConstants.LOTTO_TICKET_AMOUNT, "로또 구매 금액 이하입니다.")),
	WRONG_AMOUNT(amount -> checkArgument(amount % LottoConstants.LOTTO_TICKET_AMOUNT == 0,
		"1000원 단위로 입력해 주세요."));

	private Validator<Integer> validator;

	LottoPurchaseAmountValidator(Validator<Integer> validator) {
		this.validator = validator;
	}

	public static void valid(Integer amount) {
		Arrays.stream(LottoPurchaseAmountValidator.values()).forEach(validator -> validator.getValidator().valid(amount));
	}

	public Validator<Integer> getValidator() {
		return validator;
	}
}
