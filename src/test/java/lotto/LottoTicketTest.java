package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    void testCheckRank() {
        List<LottoNumber> numbers = List.of(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        List<LottoNumber> winningNumbers = List.of(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(9), new LottoNumber(10));

        LottoTicket lottoTicket = new LottoTicket(numbers);
        lottoTicket.checkRank(winningNumbers);

        assertThat(lottoTicket.getRank()).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void testToString() {
        List<LottoNumber> numbers = List.of(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThat(lottoTicket.toNumbersString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
