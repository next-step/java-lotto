package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinnerNumbersTest {

    @Test
    void 등수확인() {
        WinnerNumbers winnerNumbers = new WinnerNumbers(Number.of(1, 2, 3, 4, 5, 6), Number.of(7));

        Assertions.assertThat(winnerNumbers.checkRank(Number.of(1, 2, 3, 4, 5, 6))).isEqualTo(Rank.FIRST);
        Assertions.assertThat(winnerNumbers.checkRank(Number.of(2, 3, 4, 5, 6, 7))).isEqualTo(Rank.SECOND);
        Assertions.assertThat(winnerNumbers.checkRank(Number.of(2, 3, 4, 5, 6, 8))).isEqualTo(Rank.THIRD);
        Assertions.assertThat(winnerNumbers.checkRank(Number.of(3, 4, 5, 6, 7, 8))).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(winnerNumbers.checkRank(Number.of(4, 5, 6, 7, 8, 9))).isEqualTo(Rank.FIFTH);
    }

}