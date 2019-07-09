package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoWin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    private List<Integer> INPUT_SAMPLE_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private List<Integer> INPUT_SAMPLE_ANOTHER_NUMBERS = Arrays.asList(3, 5, 7, 9, 11, 13);

    private LottoTicket ticket;

    @BeforeEach
    void setUp() {
        ticket = new LottoTicket(INPUT_SAMPLE_NUMBERS);
    }

    @Test
    void 다른_번호들과_일치수() {
        LottoTicket another = new LottoTicket(INPUT_SAMPLE_ANOTHER_NUMBERS);

        assertThat(ticket.correctWith(another)).isEqualTo(2);
    }

    @Test
    void 숫자들을_순서대로_바꾼다() {
        List<Integer> sampleNumbers = Arrays.asList(4, 3, 2, 1, 5, 6);
        LottoTicket compared = new LottoTicket(sampleNumbers);

        assertThat(compared).isEqualTo(ticket);
    }

    @Test
    void 문자열형태를_순서대로_숫자열로_바꾼다() {
        String sampleNumbers = "4, 3, 2, 1, 5, 6";
        LottoTicket compared = LottoTicket.of(sampleNumbers);
        assertThat(compared).isEqualTo(ticket);
    }

    @Test
    void check_win() {
        int bonus = 45;
        assertThat(ticket.checkWin(ticket, bonus)).isEqualTo(LottoWin.FIRST);
    }
}
