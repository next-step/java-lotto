package lotto.domain;

import static lotto.domain.LottoTicketConverter.*;
import static lotto.util.ValidationUtils.*;

public class LottoNumberText {

    private final String text;

    public LottoNumberText(String numberText) {
        validate(numberText);

        text = numberText;
    }

    private void validate(String numberText) {
        if (!validateNumbersPattern(numberText)) {
            throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_FORMAT_MESSAGE,
                    LOTTO_NUMBER_COUNT, DELIMITER));
        }
    }

    public String text() {
        return text;
    }
}
