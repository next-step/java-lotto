package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @DisplayName(value = "티켓 번호가 6개가 생성되었는지 체크")
    @Test
    void 로또_티켓_1개_생성() {
        // when
        List<Number> ticket = Arrays.asList(Number.newNumber(1),
                                            Number.newNumber(2),
                                            Number.newNumber(3),
                                            Number.newNumber(4),
                                            Number.newNumber(5),
                                            Number.newNumber(6));
        LottoTicket autoTicket = LottoTicket.newTicket(ticket);

        // then
        assertThat(autoTicket.size()).isEqualTo(LottoTicket.LOTTO_TICKET_SIZE);
    }

    @Test
    void 로또_번호가_6개가_아니면_예외() {
        // given
        List<Number> ticket = Arrays.asList(Number.newNumber(1),
                                            Number.newNumber(2),
                                            Number.newNumber(3),
                                            Number.newNumber(4),
                                            Number.newNumber(5),
                                            Number.newNumber(6),
                                            Number.newNumber(7));

        // when
        assertThatThrownBy(() -> {
            LottoTicket.newTicket(ticket);
        // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_중복되면_예외() {
        // given
        List<Number> ticket = Arrays.asList(Number.newNumber(1),
                                            Number.newNumber(2),
                                            Number.newNumber(3),
                                            Number.newNumber(4),
                                            Number.newNumber(5),
                                            Number.newNumber(5));

        // when
        assertThatThrownBy(() -> {
            LottoTicket.newTicket(ticket);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }
}