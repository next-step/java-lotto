package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MatchingCountTest {

    @DisplayName("일치한 횟수 더하기")
    @Test
    void addMatchingCount_일치한_횟수_더하기() {
        MatchingCount matchingCount = new MatchingCount();
        assertThat(matchingCount).isEqualTo(new MatchingCount());

        matchingCount = matchingCount.addMatchingCount(true);
        assertThat(matchingCount).isEqualTo(new MatchingCount(1));
    }

}
