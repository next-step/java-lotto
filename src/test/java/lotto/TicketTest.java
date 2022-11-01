package lotto;

import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TicketTest {
    @Test
    void create() {
        Ticket ticket = Ticket.create();

        assertThat(ticket.getLottoNumbers()).hasSize(6);
    }

    @Test
    void of_로또번호_6개_입력시_생성_성공() {
        Ticket ticket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(ticket.getLottoNumbers()).hasSize(6);
    }

    @Test
    void of_로또번호_6개_미만_입력시_생생_실패() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ticket.of(Arrays.asList(1, 2)));
    }

    @Test
    void of_로또번호_7개_이상_입력시_생생_실패() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void of_로또번호에_중복이있을때_생성실패() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ticket.of(Arrays.asList(1, 1, 3, 4, 5, 6)));
    }
}
