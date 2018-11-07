package lotto.domain.validator;

import com.google.common.base.Preconditions;
import lotto.domain.WinningLottoTicket;

import java.util.Arrays;

/**
 * Created by hspark on 08/11/2018.
 */
public enum WinningLottoTicketValidator {
	BONUS_NUMBER_OVERLAP(ticket -> Preconditions.checkArgument(!ticket.getNumbers().contains(ticket.getBonusNumber()),
		"보너스 볼 중복"));
	private Validator<WinningLottoTicket> validator;

	public Validator<WinningLottoTicket> getValidator() {
		return validator;
	}

	WinningLottoTicketValidator(Validator<WinningLottoTicket> validator) {
		this.validator = validator;
	}

	public static void valid(WinningLottoTicket lottoTicket) {
		Arrays.stream(WinningLottoTicketValidator.values()).forEach(validator -> validator.getValidator().valid(lottoTicket));
	}
}
