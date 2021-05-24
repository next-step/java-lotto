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
        assertThat(LottoRank.of(0, false)).isEqualTo(LottoRank.LOSE);
        assertThat(LottoRank.of(1, false)).isEqualTo(LottoRank.LOSE);
        assertThat(LottoRank.of(2, false)).isEqualTo(LottoRank.LOSE);
        assertThat(LottoRank.of(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.of(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.of(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.of(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.of(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    @DisplayName("유효하지 않은 매칭횟수")
    void invalidMatchCount(int matchCount) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.of(matchCount, true))
                .withMessageMatching("매칭 숫자에 해당하는 등수가 존재하지 않습니다.");
    }

}