package lotto.domain.lotto;

import lotto.domain.lotto.ticket.LottoNumber;
import lotto.domain.lotto.ticket.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 로또_정보_맞춘_개수_정보() {
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);

        assertThat(lottoTicket.hitNumber(Set.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)))).isEqualTo(6);
    }

    @Test
    void 로또_중복_에러_테스트() {
        assertThatThrownBy(() -> new LottoTicket(1,1,2,3,4,5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또 입력 숫자가 6개가 아닙니다.");
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