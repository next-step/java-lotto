package lotto.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    @Test
    @DisplayName("숫자 3로 MatchCount 를 찾으면 MatchCount.THREE 가 반환한다.")
    void findByValue() {
        assertThat(MatchResult.findByMatchCount(3)).isEqualTo(MatchResult.THREE);
    }

    @Test
    @DisplayName("숫자 1로 MatchCount 를 찾으면 null 를 반환한다.")
    void invalidMaxBound() {
        assertThat(MatchResult.findByMatchCount(1)).isEqualTo(null);
    }

    @ParameterizedTest(name = "MatchCount value 가 {0} 인 당첨금은 {1} 이다.")
    @CsvSource({"3,5000", "4,50000", "5,1500000", "6,2000000000"})
    void winPrice(int input, int expected) {
        assertThat(MatchResult.findByMatchCount(input).winPrice()).isEqualTo(expected);
    }
}