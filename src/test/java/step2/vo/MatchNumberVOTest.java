package step2.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchNumberVOTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void isContainsSuccessTest(int matchCount) {
        final boolean actual = MatchNumberVO.isContains(matchCount);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 7})
    void isContainsFailTest(int matchCount) {
        final boolean actual = MatchNumberVO.isContains(matchCount);
        assertThat(actual).isFalse();
    }

    @Test
    void createMatchNumberSuccessTest() {
        final MatchNumberVO actual = MatchNumberVO.createMatchNumber(6);
        final MatchNumberVO expected = MatchNumberVO.SIX;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void createMatchNumberFailTest() {
        assertThatThrownBy(() -> MatchNumberVO.createMatchNumber(7))
                .isExactlyInstanceOf(NoSuchElementException.class);
    }
}