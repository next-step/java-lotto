package lotto.domain;

import lotto.exception.NotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinnerLottoTicketTest {

    @ParameterizedTest
    @DisplayName("성공생성")
    @CsvSource(value = {"1, 2, 3, 4, 5, 6 : 7"}, delimiter = ':')
    void createSuccess(String winnerNumber, int bonusNumber) {
        assertThat(WinnerLottoTicket.of(winnerNumber, bonusNumber)).isInstanceOf(WinnerLottoTicket.class);
    }

    @ParameterizedTest
    @DisplayName("숫자 외의 다른 값 예외처리")
    @CsvSource(value = {"1, 2, 3, 4, 5, a : 7"}, delimiter = ':')
    void notNumberException(String winnerNumber, int bonusNumber) {
        assertThatExceptionOfType(NotNumberException.class)
                .isThrownBy(() -> WinnerLottoTicket.of(winnerNumber, bonusNumber));
    }

    @ParameterizedTest
    @DisplayName("당첨 번호에 보너스 번호 포함일 시 예외처리")
    @CsvSource(value = {"1, 2, 3, 4, 5, 7 : 7"}, delimiter = ':')
    void lottoTicketSizeException(String winnerNumber, int bonusNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> WinnerLottoTicket.of(winnerNumber, bonusNumber));
    }

}
