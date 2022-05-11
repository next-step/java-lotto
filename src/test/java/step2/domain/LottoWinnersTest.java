package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static step2.domain.Rank.*;

class LottoWinnersTest {

    @Test
    void rate() {
        LottoWinners lottoWinners = new LottoWinners();
        lottoWinners.add(RANK_1);
        lottoWinners.add(RANK_2);
        lottoWinners.add(RANK_5);

        assertThat(lottoWinners.rate(1_000_000)).isEqualTo(2_030);
    }
}