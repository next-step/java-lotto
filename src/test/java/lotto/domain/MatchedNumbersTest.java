package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchedNumbersTest {

    private MatchedNumbers matchedNumbers;
    @BeforeEach
    void setUp() {
        matchedNumbers = new MatchedNumbers(7);
    }

    @Test
    void 생성() {
        assertThat(matchedNumbers).isEqualTo(new MatchedNumbers(7));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void 당첨_갯수에_따른_횟수_확인(final int matchedNumberCount) {
        matchedNumbers.add(matchedNumberCount);
        assertThat(matchedNumbers.get(matchedNumberCount)).isEqualTo(1);
    }
}
