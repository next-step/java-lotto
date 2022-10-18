package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    void testGetRank() {
        assertThat(LottoRank.getRank(6)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.getRank(5)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.getRank(4)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.getRank(3)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.getRank(2)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.getRank(1)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.getRank(0)).isEqualTo(LottoRank.NONE);

    }

}
