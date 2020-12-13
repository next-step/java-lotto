package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    void 맞춘_개수가_0보다_작으면_예외() {
        // given
        int countOfMatch = -1;

        // then
        assertThatThrownBy(() -> {
            Rank.valueOf(countOfMatch, false);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 맞춘_개수가_6보다_크면_예외() {
        // given
        int countOfMatch = 7;

        // then
        assertThatThrownBy(() -> {
            Rank.valueOf(countOfMatch, false);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    void 맞춘_개수가_3개_미만이면_MISS_반환(int countOfMatch) {
        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    void 맞춘_개수가_3개이면_FIFTH_반환() {
        // given
        int countOfMatch = 3;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName(value = "모든 Rank를 테스트 한다.")
    @ParameterizedTest
    @CsvSource()
    void RankTest() {
        // given

        // when

        // then
    }
}