package step2.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void isContainsSuccessTest(int matchCount) {
        final boolean actual = MatchNumber.isContains(matchCount);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 7})
    void isContainsFailTest(int matchCount) {
        final boolean actual = MatchNumber.isContains(matchCount);
        assertThat(actual).isFalse();
    }

    @Test
    void createMatchNumberSuccessTest() {
        final MatchNumber actual = MatchNumber.createMatchNumber(6);
        final MatchNumber expected = MatchNumber.SIX;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void createMatchNumberFailTest() {
        assertThatThrownBy(() -> MatchNumber.createMatchNumber(7))
                .isExactlyInstanceOf(NoSuchElementException.class);
    }
}