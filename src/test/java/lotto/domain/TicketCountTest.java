package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TicketCountTest {
    @DisplayName("생성")
    @Test
    void create() {
        TicketCount ticketCount = new TicketCount(5);
        assertThat(ticketCount).isEqualTo(new TicketCount(5));
    }

    @DisplayName("티켓 Count 수량이 0보다 작을 경우 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfInputIsUnderZero() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new TicketCount(-1)
        );
    }
}
