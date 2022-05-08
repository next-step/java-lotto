package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningsTest {

    Winnings winnings = null;
    List<Integer> matchedThree = null;
    List<Integer> matchedFour = null;
    List<Integer> matchedFive = null;
    List<Integer> matchedAll = null;

    @BeforeEach
    void setUp() {
        winnings = new Winnings(Arrays.asList(1, 5, 10, 23, 35, 44));
        matchedThree = Arrays.asList(1, 5, 10, 21, 32, 41);
        matchedFour = Arrays.asList(1, 5, 10, 23, 32, 41);
        matchedFive = Arrays.asList(1, 5, 10, 23, 35, 41);
        matchedAll = Arrays.asList(1, 5, 10, 23, 35, 44);

        winnings.countMatchedNumbers(matchedThree);
        winnings.countMatchedNumbers(matchedFour);
        winnings.countMatchedNumbers(matchedFive);
        winnings.countMatchedNumbers(matchedAll);
    }

    @Test
    @DisplayName("당첨 개수 확인")
    void check() {
        assertThat(winnings.recordMatched()[3]).isEqualTo(1);
        assertThat(winnings.recordMatched()[4]).isEqualTo(1);
        assertThat(winnings.recordMatched()[5]).isEqualTo(1);
        assertThat(winnings.recordMatched()[6]).isEqualTo(1);
    }

}