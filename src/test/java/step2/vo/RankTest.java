package step2.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        final Rank actual = Rank.createRank(6);
        final Rank expected = Rank.FIRST;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void createMatchNumberFailTest() {
        final Rank actual = Rank.createRank(7);
        assertThat(actual).isEqualTo(Rank.NONE);
    }
}