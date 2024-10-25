package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    public void 토또의_당첨개수가_맞으면_해당랭크가_반환된다() {
        LottoRank rank = LottoRank.match(3);
        assertThat(rank).isEqualTo(LottoRank.THREE_MATCH);
    }

    @Test
    public void 당첨되지_않으면_NONE을_반환한다() {
        LottoRank rank = LottoRank.match(2);
        assertThat(rank).isEqualTo(LottoRank.NONE);
    }
}
