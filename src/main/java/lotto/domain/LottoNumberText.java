package lotto.domain;

import static lotto.domain.LottoTicketConverter.*;
import static lotto.util.ValidationUtils.*;

import java.util.Objects;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		LottoNumberText that = (LottoNumberText)o;

		return Objects.equals(text, that.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}
}
