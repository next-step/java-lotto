package lotto.utils;

import lotto.domain.value.TicketCount;
import lotto.exception.EmptySourceException;
import lotto.exception.InvalidValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputUtilsTest {

    @DisplayName("공백이 입력될 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmptySource(String input) {
        assertThatThrownBy(() -> InputUtils.createLottoCount(input)).isInstanceOf(EmptySourceException.class);
    }

    @DisplayName("금액이아닌 문자열을 입력했을 경우 예외가 발생한다.")
    @Test
    void validateString() {
        String input = "문자열 입력";

        assertThatThrownBy(() -> InputUtils.createLottoCount(input)).isInstanceOf(InvalidValueException.class);
    }

    @DisplayName("금액을 입력할 경우 LottoCount를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "14000", "23000", "42000"
    })
    void createLottoCount(String input) {
        TicketCount ticketCount = InputUtils.createLottoCount(input);

        assertThat(ticketCount).isEqualTo(TicketCount.of(input));
    }

}
