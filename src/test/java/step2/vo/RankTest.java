package step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void isContainsSuccessTest(int matchCount) {
        final boolean actual = Rank.isContains(matchCount);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7})
    void isContainsFailTest(int matchCount) {
        final boolean actual = Rank.isContains(matchCount);
        assertThat(actual).isFalse();
    }

    @Test
    void createMatchNumberSuccessTest() {
        final Rank actual = Rank.rank(6, false);
        final Rank expected = Rank.FIRST;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void createMatchNumberFailTest() {
        final Rank actual = Rank.rank(7, false);
        assertThat(actual).isEqualTo(Rank.NONE);
    }

    @Test
    @DisplayName("Rank 생성 시 보너스 여부 포함이면 2등")
    void createSecondTest() {
        final Rank actual = Rank.rank(5, true);
        final Rank expected = Rank.SECOND;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Rank 생성 시 보너스 여부 미포함이면 3등")
    void createThirdTest() {
        final Rank actual = Rank.rank(5, false);
        final Rank expected = Rank.THIRD;
        assertThat(actual).isEqualTo(expected);
    }
}