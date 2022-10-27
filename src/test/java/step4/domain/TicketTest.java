package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TicketTest {

    @DisplayName("음수 개의 티켓 생성 시 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, -6, -20})
    void ticket_count_cant_negative_number(int negative) {
        Assertions.assertThatThrownBy(() -> Ticket.from(negative))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
