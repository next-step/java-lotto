package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.exception.NotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinnerLottoTicketTest {

    @ParameterizedTest
    @DisplayName("성공생성")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void createSuccess(String args) {
        assertThat(WinnerLottoTicket.from(args)).isInstanceOf(WinnerLottoTicket.class);
    }

    @ParameterizedTest
    @DisplayName("숫자 외의 다른 값 예외처리")
    @ValueSource(strings = {"1, 2, 3, 4, 5, a", "`, 2, 3, 5, -"})
    void lottoTicketSizeException(String args) {
        assertThatExceptionOfType(NotNumberException.class)
            .isThrownBy(() -> WinnerLottoTicket.from(args));
    }

}
