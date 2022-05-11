package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningsTest {

    Winnings winnings = null;
    List<Integer> matchedFour = null;
    List<Integer> matchedFive = null;
    List<Integer> matchedFiveAndBonus = null;
    List<Integer> matchedAll = null;

    @BeforeEach
    void setUp() {
        winnings = new Winnings(Arrays.asList(1, 5, 10, 23, 35, 44), 2);
        matchedFour = Arrays.asList(1, 5, 10, 23, 32, 41);
        matchedFive = Arrays.asList(1, 5, 10, 23, 35, 41);
        matchedFiveAndBonus = Arrays.asList(2, 5, 10, 23, 35, 44);
        matchedAll = Arrays.asList(1, 5, 10, 23, 35, 44);

        winnings.countMatchedNumbers(matchedFour);
        winnings.countMatchedNumbers(matchedFive);
        winnings.countMatchedNumbers(matchedFiveAndBonus);
        winnings.countMatchedNumbers(matchedAll);
    }

    @Test
    @DisplayName("당첨 개수 확인")
    void check() {
        assertAll("당첨 개수 별 로또 현황 확인",
                () -> assertThat(winnings.recordMatched()[Matched.THREE.index()]).isEqualTo(0),
                () -> assertThat(winnings.recordMatched()[Matched.FOUR.index()]).isEqualTo(1),
                () -> assertThat(winnings.recordMatched()[Matched.FIVE.index()]).isEqualTo(1),
                () -> assertThat(winnings.recordMatched()[Matched.FIVE_AND_BONUS.index()]).isEqualTo(1),
                () -> assertThat(winnings.recordMatched()[Matched.ALL.index()]).isEqualTo(1)
        );

    }

}