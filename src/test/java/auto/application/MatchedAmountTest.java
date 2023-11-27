package auto.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MatchedAmountTest {
    @ParameterizedTest
    @CsvSource(value = {"3,THREE", "4,FOUR", "5,FIVE", "6,SIX"})
    void findByCountTest(int count, String expectedEnum) {
        // when
        MatchedAmount matchedAmount = MatchedAmount.findByCount(count);
        // then
        assertThat(matchedAmount).isEqualTo(MatchedAmount.valueOf(expectedEnum));
    }

    @Test
    void getMatchedCountMapTest() {
        // when
        Map<Integer, Integer> matchedCountMap = MatchedAmount.getMatchedCountMap();
        // then
        assertThat(matchedCountMap.keySet()).isEqualTo(Set.of(3, 4, 5, 6));
    }
}
