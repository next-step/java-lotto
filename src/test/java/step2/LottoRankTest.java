package step2;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.lotto.domain.LottoRank;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource({
        "6, FIRST",
        "5, SECOND",
        "4, THIRD",
        "3, FORTH",
        "0, LOSE",
        "2, LOSE",
        "1, LOSE"
    })
    void matchLottoRankMatchCount(int matchCount, LottoRank expectedRank) {
        assertThat(LottoRank.matchLottoRank(matchCount)).isEqualTo(expectedRank);
    }
}
