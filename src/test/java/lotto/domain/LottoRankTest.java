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
        assertThat(LottoRank.of(0)).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.of(1)).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.of(2)).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.of(3)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.of(4)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.of(5)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.of(6)).isEqualTo(LottoRank.FIRST);
    }
}
