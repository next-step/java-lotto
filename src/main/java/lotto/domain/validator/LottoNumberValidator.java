package lotto.domain.validator;

import lotto.domain.LottoConstants;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.function.Predicate;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by hspark on 10/11/2018.
 */
public enum LottoNumberValidator {
	WRONG_LOTTO_NUMBER(lottoNumber -> checkArgument(!lottoNumberRangePredicate().test(lottoNumber.getNumber()),
		"잘못된 로또 번호입니다."));

	LottoNumberValidator(Validator<LottoNumber> validator) {
		this.validator = validator;
	}

	private Validator<LottoNumber> validator;
	private static Predicate<Integer> lottoNumberRangePredicate() {
		return i -> i > LottoConstants.LOTTO_MAX_NUMBER || i < LottoConstants.LOTTO_MIN_NUMBER;
	}

	public Validator<LottoNumber> getValidator() {
		return validator;
	}

	public static void valid(LottoNumber lottoNumber) {
		Arrays.stream(LottoNumberValidator.values()).forEach(validator -> validator.getValidator().valid(lottoNumber));
	}
}
