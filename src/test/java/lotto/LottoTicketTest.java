package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoTicketTest {
    @Test
    void hasBonusNumberTest() {
        LottoTicket winningNumber = new LottoTicket(Arrays.asList(1, 5, 7, 10, 13, 15));
        winningNumber.bonusNumber(45);
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 5, 7, 10, 13, 45));
        assertThat(lottoTicket.hasBonusNumber(winningNumber)).isTrue();
    }

    @Test
    void createLottoTicketTest() {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.showTicketNumber().stream()
                .forEach(
                        number -> System.out.println(number)
                );
        assertThat(lottoTicket.showTicketNumber().size()).isEqualTo(6);
    }

    @Test
    void createLottoTicketWithNumber() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 5, 10, 40, 45, 6));
        assertThat(lottoTicket.showTicketNumber()).containsExactly(1, 5, 6, 10, 40, 45);
    }

    @Test
    void findMatchCountTest() {
        LottoTicket ticket1 = new LottoTicket(Arrays.asList(1, 5, 10, 40, 45, 6));
        LottoTicket ticket2 = new LottoTicket(Arrays.asList(1, 5, 10, 20, 25, 30));
        assertThat(ticket1.findMatchCount(ticket1)).isEqualTo(6);
        assertThat(ticket1.findMatchCount(ticket2)).isEqualTo(3);
    }
}
