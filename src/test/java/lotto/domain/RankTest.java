package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @ParameterizedTest
    @CsvSource({
            "FIRST,  6, 2000000000",
            "SECOND, 5, 1500000",
            "THIRD,  4, 50000",
            "FOURTH, 3, 5000"
    })
    void 등수별_일치_개수와_상금을_가진다(Rank rank, int matchCount, long prize) {
        assertThat(rank.getMatchCount()).isEqualTo(matchCount);
        assertThat(rank.getPrize()).isEqualTo(prize);
    }

    @ParameterizedTest
    @CsvSource({
            "6, FIRST",
            "5, SECOND",
            "4, THIRD",
            "3, FOURTH"
    })
    void 일치_개수에_맞는_등수를_반환한다(int matchCount, Rank expected) {
        assertThat(Rank.from(matchCount)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 일치_개수가_3개_미만이면_낙첨이다(int matchCount) {
        Rank rank = Rank.from(matchCount);

        assertThat(rank).isEqualTo(Rank.MISS);
        assertThat(rank.getPrize()).isZero();
    }
}
