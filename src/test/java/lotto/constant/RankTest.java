package lotto.constant;

import lotto.domain.LottoNumbers;
import lotto.exception.InvalidMatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {

    @Test
    @DisplayName("6개가 일치하면 1등이다.")
    void first() {
        assertThat(Rank.valueOf(6,true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6,false)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개가 일치하고 보너스 볼이 일치하면 2등이다.")
    void second() {
        assertThat(Rank.valueOf(5,true)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개가 일치하고 보너스 볼이 일치하지 않으면 3등이다.")
    void third() {
        assertThat(Rank.valueOf(5,false)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개가 일치하면 4등이다.")
    void fourth() {
        assertThat(Rank.valueOf(4,true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4,false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개가 일치하면 5등이다.")
    void fifth() {
        assertThat(Rank.valueOf(3,true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3,false)).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest(name = "{0}개 일치하면 MISS 를 반환단다.")
    @ValueSource(ints = {0, 1, 2})
    void miss(int matchCount) {
        assertThat(Rank.valueOf(matchCount, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(matchCount, false)).isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("일치하는 개수가 7개 이상이면 InvalidMatchCount.class 를 반환한다.")
    void invalid() {
        assertThatThrownBy(() -> Rank.valueOf(7, true)).isInstanceOf(InvalidMatchCount.class)
                .hasMessage("matchCount 는 " + LottoNumbers.LOTTO_NUMBER_COUNT + "개를 초과할 수 없습니다.");

        assertThatThrownBy(() -> Rank.valueOf(7, false)).isInstanceOf(InvalidMatchCount.class)
                .hasMessage("matchCount 는 " + LottoNumbers.LOTTO_NUMBER_COUNT + "개를 초과할 수 없습니다.");
    }
}