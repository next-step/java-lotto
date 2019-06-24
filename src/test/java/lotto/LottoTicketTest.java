package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    private List<Integer> INPUT_SAMPLE_NUMBERS = Arrays.asList(1,2,3,4,5,6);
    private List<Integer> INPUT_SAMPLE_ANOTHER_NUMBERS = Arrays.asList(3,5,7,9,11,13);

    @Test
    void 다른_번호들과_일치수() {
        LottoTicket ticket = new LottoTicket(INPUT_SAMPLE_NUMBERS);
        LottoTicket another = new LottoTicket(INPUT_SAMPLE_ANOTHER_NUMBERS);

        assertThat(ticket.correctWith(another)).isEqualTo(2);
    }
}
