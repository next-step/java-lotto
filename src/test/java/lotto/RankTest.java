package lotto;

import lotto.domain.Ranking;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RankTest {
    Ranking ranking = Ranking.FIRST_CLASS;

    @Test
    public void 랭크_반환값_테스트() {
        assertThat(ranking.getRank()).isEqualTo(1);
    }

    @Test
    public void 로또_맞춘_개수_테스트() {
        assertThat(ranking.getCountMatching()).isEqualTo(6);
    }

    @Test
    public void 로또_금액_반환_테스트() {
        assertThat(ranking.getProfit()).isEqualTo(2000000000);
    }
}
