package auto.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MatchedAmountTest {
    @ParameterizedTest
    @CsvSource(value = {"3,THREE", "4,FOUR", "5,FIVE", "6,SIX"})
    void findByCountTest(int count, String expectedEnum) {
        // when
        MatchedAmount matchedAmount = MatchedAmount.findByCount(count, false);
        // then
        assertThat(matchedAmount).isEqualTo(MatchedAmount.valueOf(expectedEnum));
    }

    @Test
    void findByCountTest() {
        // when
        MatchedAmount matchedAmount = MatchedAmount.findByCount(5, true);
        // then
        assertThat(matchedAmount).isEqualTo(MatchedAmount.FIVE_AND_BONUS);
    }
}
