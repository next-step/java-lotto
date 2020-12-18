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
<<<<<<< HEAD
    void 맞춘_개수가_3개이면_FIFTH_반환() {
=======
    void 맞춘_개수가_3개_이면_FIFTH() {
>>>>>>> 8626d00... test : 보너스 당첨 안됐을 때 케이스 추가
        // given
        int countOfMatch = 3;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

<<<<<<< HEAD
    @DisplayName(value = "모든 Rank를 테스트 한다.")
    @ParameterizedTest
    @CsvSource()
    void RankTest() {
        // given

        // when

        // then
=======
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
>>>>>>> 8626d00... test : 보너스 당첨 안됐을 때 케이스 추가
    }
}