package lotto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    void findRankTest() {
        assertThat(LottoRank.find(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.find(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.find(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.find(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.find(2, false)).isEqualTo(LottoRank.NOT_MATCH);
        assertThat(LottoRank.find(1, false)).isEqualTo(LottoRank.NOT_MATCH);
        assertThat(LottoRank.find(0, false)).isEqualTo(LottoRank.NOT_MATCH);

        assertThat(LottoRank.find(6, true)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.find(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.find(4, true)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.find(3, true)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.find(2, true)).isEqualTo(LottoRank.NOT_MATCH);
        assertThat(LottoRank.find(1, true)).isEqualTo(LottoRank.NOT_MATCH);
        assertThat(LottoRank.find(0, true)).isEqualTo(LottoRank.NOT_MATCH);
    }
}
