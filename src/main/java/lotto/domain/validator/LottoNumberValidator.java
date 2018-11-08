package lotto.domain.validator;

import lotto.domain.LottoConstants;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.function.Predicate;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by hspark on 07/11/2018.
 */
public enum LottoNumberValidator {
	LOTTO_NUMBER_CHECK(ticket -> checkArgument(ticket.getNumbers().size()
		== LottoConstants.LOTTO_NUMBER_COUNT, "로또 번호는 6자리여야합니다.")),
	LOTTO_NUMBER_OVERLAP_CHECK(ticket -> checkArgument(ticket.getNumbers().stream().distinct().count()
		== LottoConstants.LOTTO_NUMBER_COUNT, "중복은 허용되지 않습니다.")),
	WRONG_LOTTO_NUMBER(ticket -> checkArgument(!ticket.getNumbers().stream()
		.filter(lottoNumberRangePredicate()).findAny().isPresent(), "잘못된 로또 번호입니다."));

	private Validator<LottoTicket> validator;

	LottoNumberValidator(Validator<LottoTicket> validator) {
		this.validator = validator;
	}

	public Validator<LottoTicket> getValidator() {
		return validator;
	}

	private static Predicate<Integer> lottoNumberRangePredicate() {
		return i -> i > LottoConstants.LOTTO_MAX_NUMBER || i < LottoConstants.LOTTO_MIN_NUMBER;
	}

	public static void valid(LottoTicket lottoTicket) {
		Arrays.stream(LottoNumberValidator.values()).forEach(validator -> validator.getValidator().valid(lottoTicket));
	}
}
