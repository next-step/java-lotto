package lotto.domain.validator;

import lotto.domain.LottoConstants;
import java.lang.Integer;

import java.util.Arrays;
import java.util.function.Predicate;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by hspark on 10/11/2018.
 */
public enum LottoNumberValidator {
	WRONG_LOTTO_NUMBER(lottoNumber -> checkArgument(!lottoNumberRangePredicate().test(lottoNumber),
		"잘못된 로또 번호입니다."));

	LottoNumberValidator(Validator<Integer> validator) {
		this.validator = validator;
	}

	private Validator<Integer> validator;
	private static Predicate<Integer> lottoNumberRangePredicate() {
		return i -> i > LottoConstants.LOTTO_MAX_NUMBER || i < LottoConstants.LOTTO_MIN_NUMBER;
	}

	public Validator<Integer> getValidator() {
		return validator;
	}

	public static void valid(Integer lottoNumber) {
		Arrays.stream(LottoNumberValidator.values()).forEach(validator -> validator.getValidator().valid(lottoNumber));
	}
}
