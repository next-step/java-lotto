package lotto.domain;

import lotto.dto.WinStats;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {
    @DisplayName("로또 티켓 수동 구매 성공")
    @Test
    void create_manual() {
        Money money = new Money(1000);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<LottoTicket> manualLottoTicket = Collections.singletonList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTickets manualLottoTickets = new LottoTickets(money, lottoTickets, manualLottoTicket);

        assertThat(manualLottoTickets).isEqualTo(new LottoTickets(money, lottoTickets, manualLottoTicket));
    }

    @DisplayName("로또 티켓 구입 개수 확인")
    @Test
    void size() {
        Money money = new Money(4000);
        List<LottoTicket> lottoTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new LottoTicket(Arrays.asList(13, 14, 15, 16, 17, 18)));
        List<LottoTicket> manualLottoTickets = Collections.singletonList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 22, 23, 24), 7);
        LottoTickets result = new LottoTickets(money, lottoTickets, manualLottoTickets);

        assertThat(result.getLottoTickets().size()).isEqualTo(4);

    }

    @DisplayName("수동으로 입력한 로또 개수가 금액을 초과할 경우")
    @Test
    void invalidMoney_manual() {
        Money money = new Money(3000);
        List<LottoTicket> lottoTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new LottoTicket(Arrays.asList(13, 14, 15, 16, 17, 18)));
        List<LottoTicket> manualLottoTickets = Collections.singletonList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> new LottoTickets(money, lottoTickets, manualLottoTickets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 통계 수동")
    @Test
    void getWinStats_manual() {
        Money money = new Money(4000);
        List<LottoTicket> lottoTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new LottoTicket(Arrays.asList(13, 14, 15, 16, 17, 18)));
        List<LottoTicket> manualTickets = Collections.singletonList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 22, 23, 24), 7);

        WinStats result = new LottoTickets(money, lottoTickets, manualTickets).getWinStats(winLotto, money);
        System.out.println(result.toString());
        assertThat(result.getYield()).isEqualTo(2.5f);
    }

}