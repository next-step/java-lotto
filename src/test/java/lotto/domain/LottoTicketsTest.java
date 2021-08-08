package lotto.domain;

import lotto.dto.WinStats;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {
    @DisplayName("로또 티켓 구매 성공")
    @Test
    void create() {
        Money money = new Money(1000);
        LottoTickets lottoTickets = new LottoTickets(money, Collections.singletonList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6))));
        assertThat(lottoTickets).isEqualTo(new LottoTickets(money, Collections.singletonList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)))));
    }


    @DisplayName("로또 티켓 구입 금액 부족")
    @Test
    void invalidMoney() {
        Money money = new Money(1000);
        assertThatThrownBy(() -> new LottoTickets(money, Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new LottoTicket(Arrays.asList(13, 14, 15, 16, 17, 18))))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 통계")
    @Test
    void getWinStats() {
        Money money = new Money(3000);
        List<LottoTicket> lottoTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new LottoTicket(Arrays.asList(13, 14, 15, 16, 17, 18)));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 22, 23, 24), 7);

        WinStats result = new LottoTickets(money, lottoTickets).getWinStats(winLotto);
        System.out.println(result.toString());
        assertThat(result.getYield()).isEqualTo(1.6666666f);
    }

}