package lotto.domain.validator;

import lotto.domain.LottoConstants;
import lotto.domain.LottoTicket;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by hspark on 07/11/2018.
 */
public enum LottoTicketValidator {
	LOTTO_NUMBER_CHECK(ticket -> checkArgument(ticket.getNumbers().size()
		== LottoConstants.LOTTO_NUMBER_COUNT, "로또 번호는 6자리여야합니다.")),
	LOTTO_NUMBER_OVERLAP_CHECK(ticket -> checkArgument(ticket.getNumbers().stream().distinct().count()
		== LottoConstants.LOTTO_NUMBER_COUNT, "중복은 허용되지 않습니다."));

	private Validator<LottoTicket> validator;

	LottoTicketValidator(Validator<LottoTicket> validator) {
		this.validator = validator;
	}

	public Validator<LottoTicket> getValidator() {
		return validator;
	}

	public static void valid(LottoTicket lottoTicket) {
		Arrays.stream(LottoTicketValidator.values()).forEach(validator -> validator.getValidator().valid(lottoTicket));
	}
}
