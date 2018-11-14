package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JackpotTest {

    @Test
    public void 맞춘개수_0개_금액_0원() {
        Rank rank = Rank.valueOf(1, false);
        assertThat(rank.getPrizeMoney()).isEqualTo(0);
    }

    @Test
    public void 맞춘개수_6개_금액_0원() {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank.getPrizeMoney()).isEqualTo(2_000_000_000);
    }

    @Test
    public void 오등이_3번된_경우_금액_15000원() {
        int totalPrize = Rank.FIFTH.getTotalPrizeMoney(3);
        assertThat(totalPrize).isEqualTo(15_000);
    }

    @Test
    public void 삼등_당첨_확인() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank.getPrizeMoney()).isEqualTo(1_500_000);
    }

    @Test
    public void 이등_당첨_확인() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank.getPrizeMoney()).isEqualTo(30_000_000);
    }
}
