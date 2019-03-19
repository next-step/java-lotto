package lotto.enums;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RankTest {

    @Test
    public void RANK_타입_반환() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 당첨_금액_계산() {
        assertThat(Rank.FIRST.getTotalReward(1)).isEqualTo(2_000_000_000L);
        assertThat(Rank.SECOND.getTotalReward(1)).isEqualTo(30_000_000L);
    }

    @Test
    public void 문자열_반환() {
        assertThat(Rank.FIRST.toString()).isEqualTo("6개 일치 (2000000000원) - ");
        assertThat(Rank.SECOND.toString()).isEqualTo("5개 일치, 보너스 볼 일치 (30000000원) - ");
    }
}
