package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {
    @DisplayName("총 구매금액이 주어졌을 때, 1000원 단위가 아닌 유효하지 않은 경우에 예외발생")
    @Test
    void invalidAmountCases() {
        assertThatThrownBy(() -> new TicketMachine(new Amount(14500), 3))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
