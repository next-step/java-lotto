package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRoundTest {
    @Test
    void test_get_winners() {
        LottoTicket ticket1 = LottoTicket.from(1, 2, 3, 4, 5, 6);
        LottoTicket ticket2 = LottoTicket.from(3, 4, 9, 10, 11, 12);
        LottoRound round = new LottoRound(List.of(ticket1, ticket2));
        LottoTicket winningTicket = LottoTicket.from(3, 4, 5, 6, 7, 8);

        assertThat(round.finishRound(winningTicket)).containsExactly(LottoResult.THIRD, LottoResult.NONE);
    }
}
