package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TicketTest {

    @DisplayName("Price 생성 시 0미만의 수를 입력하면 예외처리한다")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -3000})
    void price_can_positive(int negativePrice) {
        Assertions.assertThatThrownBy(() -> Ticket.from(negativePrice)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Price 생성 시 1000원 단위로 입력하지 않으면 예외처리 한다")
    @ParameterizedTest
    @ValueSource(ints = {500, 3500, 10005})
    void price_can_1000s_multiply(int price) {
        Assertions.assertThatThrownBy(() -> Ticket.from(price)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
