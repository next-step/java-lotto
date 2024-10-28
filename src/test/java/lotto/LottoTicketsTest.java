package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {
    @Test
    @DisplayName("로또 개수로 생성할 때 티켓 개수 확인")
    void createByCount() {
        LottoTickets lottoTickets = LottoTickets.createByCount(3);

        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 개수로 생성할 때 음수 입력시 예외 발생")
    void createByCount_Negative() {
        assertThatThrownBy(() -> LottoTickets.createByCount(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 티켓은 0개 이상이어야 합니다.");
    }

    @Test
    @DisplayName("로또 가격으로 생성할 때 티켓 개수 확인")
    void createByPrice() {
        int price = 3000;
        LottoTickets lottoTickets = LottoTickets.createByPrice(price);

        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 가격으로 생성할 때 음수 입력시 예외 발생")
    void createByPrice_Negative() {
        assertThatThrownBy(() -> LottoTickets.createByPrice(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구매 금액은 0원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("로또 티켓들 Winning 확인")
    void calculateWinningResults() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(1, 2, 3, 4, 5, 6));
        tickets.add(new LottoTicket(1, 2, 3, 4, 5, 7));
        tickets.add(new LottoTicket(1, 2, 3, 4, 5, 8));
        tickets.add(new LottoTicket(9, 10, 11, 12, 13, 14));
        LottoTickets lottoTickets = new LottoTickets(tickets);

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new LottoTicket(1, 2, 3, 4, 5, 6), new LottoNumber(7));

        assertThat(lottoTickets.calculateWinningResults(lottoWinningNumbers)).containsExactly(Winning.FIRST, Winning.SECOND, Winning.THIRD, Winning.NONE);
    }

    @Test
    @DisplayName("로또 티켓들 merge 확인")
    void merge() {
        LottoTicket ticket1 = LottoTicket.createByString("1, 2, 3, 4, 5, 6");
        LottoTicket ticket2 = LottoTicket.createByString("7, 8, 9, 10, 11, 12");
        LottoTicket ticket3 = LottoTicket.createByString("13, 14, 15, 16, 17, 18");

        LottoTickets firstTickets = new LottoTickets(Arrays.asList(ticket1, ticket2));
        LottoTickets secondTickets = new LottoTickets(Arrays.asList(ticket3));

        LottoTickets mergedTickets = firstTickets.merge(secondTickets);

        assertThat(3).isEqualTo( mergedTickets.size());
        assertThat(mergedTickets.get(0)).isEqualTo(ticket1);
        assertThat(mergedTickets.get(1)).isEqualTo(ticket2);
        assertThat(mergedTickets.get(2)).isEqualTo(ticket3);
    }
}
