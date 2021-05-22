package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoRankTest {

    @Test
    @DisplayName("기본 등수조회")
    void basicRank() {
        // given when then
        assertThat(LottoRank.of(0)).isEqualTo(LottoRank.LOSE);
        assertThat(LottoRank.of(1)).isEqualTo(LottoRank.LOSE);
        assertThat(LottoRank.of(2)).isEqualTo(LottoRank.LOSE);
        assertThat(LottoRank.of(3)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.of(4)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.of(5)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.of(6)).isEqualTo(LottoRank.FIRST);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    @DisplayName("유효하지 않은 매칭횟수")
    void invalidMatchCount(int matchCount) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.of(matchCount));
    }

}