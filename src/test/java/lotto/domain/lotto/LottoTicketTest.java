package lotto.domain.lotto;

import lotto.domain.lotto.ticket.LottoNumber;
import lotto.domain.lotto.ticket.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 로또_정보_맞춘_개수_정보() {
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);

        assertThat(lottoTicket.hitNumber(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))).isEqualTo(6);
    }

    @Test
    void 로또_displayNumber_테스트() {
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        assertThat(lottoTicket.displayNumbers()).isEqualTo(List.of("1", "2", "3", "4", "5", "6"));

    }

    @Test
    void 로또_displayNumber_정렬_테스트() {
        LottoTicket lottoTicket = new LottoTicket(3, 4, 5, 1, 2, 6);
        assertThat(lottoTicket.displayNumbers()).isEqualTo(List.of("1", "2", "3", "4", "5", "6"));
    }

    @Test
    void 보너스_번호_존재_성공_테스트() {
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        assertThat(lottoTicket.isBonus(new LottoNumber(3))).isTrue();
    }

    @Test
    void 보너스_번호_존재_실패_테스트() {
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        assertThat(lottoTicket.isBonus(new LottoNumber(11))).isFalse();
    }
}