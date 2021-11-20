package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoTicketTest {

    @Test
    @DisplayName("티켓 번호 6개 확인")
    void autoTicket() {
        assertThat(AutoTicket.ticket().size()).isEqualTo(6);
    }

}
