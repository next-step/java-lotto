package lotto;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    private List<Integer> INPUT_SAMPLE_NUMBERS = Arrays.asList(1,2,3,4,5,6);
    private List<Integer> INPUT_SAMPLE_ANOTHER_NUMBERS = Arrays.asList(3,5,7,9,11,13);

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
    void 문자열형태를_순서대로_숫자열로_바꾼다() {
        String sampleNumbers = "4, 3, 2, 1, 5, 6";
        LottoTicket compared = new LottoTicket(sampleNumbers);

        assertThat(compared).isEqualTo(ticket);
    }

    @Test
    void to_string() {
        assertThat(ticket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
