package lotto.domain;

import static lotto.domain.LottoTicketConverter.*;
import static lotto.util.ValidationUtils.*;

import java.util.Optional;

public class LottoNumberText {

	private final String text;

	public LottoNumberText(String numberText) {
		text = validText(numberText);
	}

	private String validText(String numberText) {
		return Optional.ofNullable(numberText)
			.filter(str -> LOTTO_NUMBERS_PATTERN.matcher(str)
				.find())
			.orElseThrow(() -> new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT_MESSAGE));
	}

	public String text() {
		return text;
	}
}
