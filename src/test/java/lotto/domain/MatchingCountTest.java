package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MatchingCountTest {

    @DisplayName("일치한 횟수 더하기")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void addMatchingCount_일치한_횟수_더하기() {
        MatchingCount matchingCount = new MatchingCount();
        MatchingCount addMatchingCount = matchingCount.addMatchingCount();

        assertAll(
                () -> assertThat(matchingCount).isEqualTo(new MatchingCount()),
                () -> assertThat(addMatchingCount).isEqualTo(new MatchingCount(1))
        );
    }

}
