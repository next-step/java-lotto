package step2.domain.entity;

import org.junit.jupiter.api.Test;
import step2.domain.vo.LottoPrize;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    void 발급받은_티켓에_3개가_일치하는_로또가_2장이_존재한다() {
        final var tickets = createTestTickets();

        final var actual = tickets.getLottoRankCount(LottoPrize.FOURTH);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 로또_당첨_수익률을_계산한다() {
        final var tickets = createTestTickets();

        final var actual = tickets.getTotalRate();

        assertThat(actual).isEqualTo(5.0);
    }

    private LottoTickets createTestTickets() {
        final var lotto1 = Lotto.winner("1, 2, 3, 4, 5, 6");
        final var lotto2 = Lotto.winner("1, 2, 3, 4, 5, 6");
        final var ticket1 = new LottoTicket(lotto1, LottoPrize.FOURTH);
        final var ticket2 = new LottoTicket(lotto2, LottoPrize.FOURTH);

        return new LottoTickets(ticket1, ticket2);
    }

}
