package step2.domain.entity;

import org.junit.jupiter.api.Test;
import step2.domain.vo.LottoPrize;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    void 로또_당첨_수익률을_계산한다() {
        final var tickets = createTestTickets();
        final var lottoPrizes = List.of(LottoPrize.FOURTH, LottoPrize.FOURTH);

        final var actual = tickets.getTotalRate(lottoPrizes);

        assertThat(actual).isEqualTo(5.0);
    }

    private LottoTickets createTestTickets() {
        final var lotto1 = Lotto.winner("1, 2, 3, 4, 5, 6");
        final var lotto2 = Lotto.winner("1, 2, 3, 4, 5, 6");
        final var ticket1 = new LottoTicket(lotto1);
        final var ticket2 = new LottoTicket(lotto2);

        return new LottoTickets(List.of(ticket1, ticket2));
    }

}
