package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @DisplayName(value = "맞춘 개수가 0보다 작으면 예외")
    @Test
    void 맞춘_개수는_1보다_작을_수_없다() {
        // given
        int countOfMatch = -1;


        // then
        assertThatThrownBy(() -> {
            // when
            Rank.valueOf(countOfMatch, false);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "맞춘 개수가 6보다 크면 예외")
    @Test
    void 맞춘_개수는_6보다_클_수_없다() {
        // given
        int countOfMatch = 7;


        // then
        assertThatThrownBy(() -> {
            // when
            Rank.valueOf(countOfMatch, false);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "맞춘 개수가 3미만 이면, MISS를 반환")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    void 맞춘_개수가_3미만_이면_MISS(int countOfMatch) {
        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    void 맞춘_개수가_3개_이면_FIFTH() {
        // given
        int countOfMatch = 3;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 맞춘_개수가_4개_이면_FOURTH() {
        // given
        int countOfMatch = 4;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 맞춘_개수가_5개_이면_THIRD() {
        // given
        int countOfMatch = 5;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 맞춘_개수가_6개_이면_FIRST() {
        // given
        int countOfMatch = 6;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName(value = "5개가 맞고, 보너스 번호가 맞으면 SECOND 반환")
    @Test
    void 보너스_당첨_테스트() {
        // given
        int countOfMatch = 5;
        boolean matchBonus = true;

        // when
        Rank rank = Rank.valueOf(countOfMatch, true);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}