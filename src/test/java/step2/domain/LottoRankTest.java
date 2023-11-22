package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.domain.LottoRank;

class LottoRankTest {

    @Test
    public void checkRank() {

        Assertions.assertThat(LottoRank.valueOf("FIRST")).isEqualTo(LottoRank.FIRST);
        Assertions.assertThat(LottoRank.valueOf("SECOND")).isEqualTo(LottoRank.SECOND);
        Assertions.assertThat(LottoRank.valueOf("THIRD")).isEqualTo(LottoRank.THIRD);
    }
}