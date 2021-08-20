package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoTicketOfficeTest {

    private LottoTicketOffice lottoTicketOffice;

    @BeforeEach
    void 환경설정() {
        lottoTicketOffice = new LottoTicketOffice();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "999,0", "1001,1", "1999,1"})
    void 로또_가격은_1000원(int amount, int count) {
        List<LottoTicket> lottoTickets = lottoTicketOffice.buyLotto(amount);
        assertThat(lottoTickets.size()).isEqualTo(count);
    }

    @Test
    void 로또_구입_금액만큼_발급() {
        int amount = 14000;
        List<LottoTicket> lottoTickets = lottoTicketOffice.buyLotto(amount);
        assertThat(lottoTickets.size()).isEqualTo(14);
    }

}
