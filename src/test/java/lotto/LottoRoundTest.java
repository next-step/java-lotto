package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRoundTest {
    @Test
    void test_get_winners() {
        LottoTicket ticket1 = LottoTicket.of(1, 2, 3, 4, 5, 6);
        LottoTicket ticket2 = LottoTicket.of(1, 2, 3, 4, 5, 7);
        LottoRound round = new LottoRound(List.of(ticket1, ticket2));

        WinningLotto winningLotto = new WinningLotto(LottoTicket.of(1, 2, 3, 4, 5, 6), LottoNumber.of(7));

        assertThat(round.finishRound(winningLotto)).contains(LottoResult.FIRST, LottoResult.BONUS);
    }
}
