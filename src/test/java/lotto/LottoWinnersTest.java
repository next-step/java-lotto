package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinnersTest {
    @Test
    void name() {
        LottoWinners winners = new LottoWinners(List.of(
                new LottoWinner(3, LottoTicket.create()),
                new LottoWinner(3, LottoTicket.create()),
                new LottoWinner(4, LottoTicket.create())
        ));

        assertThat(winners.getWinnerCount(LottoWinnerClass.getByMatchingCount(3))).isEqualTo(2);
        assertThat(winners.getWinnerCount(LottoWinnerClass.getByMatchingCount(4))).isEqualTo(1);
    }
}
