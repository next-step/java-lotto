package lotto.prize;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.prize.Prize;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    void getPrizeByScoreTest() {
        assertThat(Prize.getPrizeByScore(12)).isEqualTo(Prize.FIRST);
        assertThat(Prize.getPrizeByScore(11)).isEqualTo(Prize.SECOND);
        assertThat(Prize.getPrizeByScore(10)).isEqualTo(Prize.THIRD);
        assertThat(Prize.getPrizeByScore(8)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.getPrizeByScore(6)).isEqualTo(Prize.FIFTH);

        assertThat(Prize.getPrizeByScore(0)).isEqualTo(Prize.NOTHING);
        assertThat(Prize.getPrizeByScore(-1)).isEqualTo(Prize.NOTHING);
        assertThat(Prize.getPrizeByScore(5)).isEqualTo(Prize.NOTHING);
        assertThat(Prize.getPrizeByScore(32)).isEqualTo(Prize.NOTHING);
    }
}
