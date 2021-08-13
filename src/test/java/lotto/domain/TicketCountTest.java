package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.WrongTicketCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TicketCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("티켓장수는 0이상인 양수로 선언할수 있다.")
    void positive_tieckt_count(int ticketCount) {
        assertThatCode(() -> new TicketCount(ticketCount))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    @DisplayName("티켓장수가 0미만의 음수로 선언될경우 예외를 던진다.")
    void negative_tieckt_count(int ticketCount) {
        assertThatThrownBy(() -> new TicketCount(ticketCount))
            .isInstanceOf(WrongTicketCountException.class);
    }
}