package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("로또 번호가 맞은 개수에 대한 순위를 반환한다.")
    void match() {

        assertSoftly(softly -> {
            assertThat(LottoRank.getLottoRank(6)).isEqualTo(LottoRank.FIRST);
            assertThat(LottoRank.getLottoRank(5)).isEqualTo(LottoRank.SECOND);
            assertThat(LottoRank.getLottoRank(4)).isEqualTo(LottoRank.THIRD);
            assertThat(LottoRank.getLottoRank(3)).isEqualTo(LottoRank.FOURTH);
            assertThat(LottoRank.getLottoRank(2)).isEqualTo(LottoRank.NO_MATCH);

        });
    }
}
