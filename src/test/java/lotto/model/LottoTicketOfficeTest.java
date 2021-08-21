package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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

    @Test
    void 로또_수동_구입() {
        List<String> numbers = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");

        List<LottoTicket> lottoTickets = lottoTicketOffice.buyLotto(3000, numbers);

        LottoTicket lottoTicket = LottoTicket.of("1,2,3,4,5,6");
        LottoTicket lottoTicket2 = LottoTicket.of("2,3,4,5,6,7");

        assertThat(lottoTickets.size()).isEqualTo(3);
        assertThat(lottoTickets).contains(lottoTicket, lottoTicket2);

    }

    @Test
    void 로또_수동_발급시_잘못된_번호_예외발생() {
        assertThatThrownBy(
                () -> lottoTicketOffice.buyLotto(2000, Arrays.asList("1,2,3,4,5"))
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
