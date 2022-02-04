package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

    @DisplayName("2등 확인")
    @Test
    void checkSecond() {
        // when
        final LottoRank lottoRank = LottoRank.getRank(5, true);

        // then
        assertThat(lottoRank).isEqualTo(lottoRank.SECOND);
    }

    @DisplayName("3등 확인")
    @Test
    void checkThird() {
        // when
        final LottoRank lottoRank = LottoRank.getRank(5, false);

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("1등 확인")
    @Test
    void checkFirst() {
        // when
        final LottoRank lottoRank = LottoRank.getRank(6, false);

        // then
        assertThat(lottoRank).isEqualTo(lottoRank.FIRST);
    }

    @DisplayName("미당첨 확인")
    @ValueSource(ints = {0, 1, 2})
    @ParameterizedTest
    void checkFail(final int matchCount) {
        // when
        final LottoRank lottoRank = LottoRank.getRank(matchCount, false);

        // then
        assertThat(lottoRank).isEqualTo(lottoRank.FAIL);
    }
}
