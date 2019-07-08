package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-26
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoRankTest {
    @Test
    void match() {
        assertThat(LottoRank.of(0, false)).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.of(1, false)).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.of(2, false)).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.of(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.of(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.of(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.of(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.of(6, false)).isEqualTo(LottoRank.FIRST);
    }
}
