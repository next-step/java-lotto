package step2;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("일치하는 숫자 별로 로또의 등수를 반환한다.")
    void matchLottoRankMatchCount(int matchCount, LottoRank expectedRank) {
        assertThat(LottoRank.matchLottoRank(matchCount)).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @CsvSource({
        "1, FIRST, 2_000_000_000",
        "2, SECOND, 3_000_000",
        "3, THIRD, 150_000",
        "4, FORTH, 20_000",
        "5, LOSE, 0",
    })
    @DisplayName("등수 별 총 당첨 금액을 반환한다.")
    void lottoRankTotalPrizeAmountTest(int scoreCount, LottoRank lottoRank, int totalPrize) {
        assertThat(lottoRank.lottoRankTotalPrizeAmount(scoreCount)).isEqualTo(totalPrize);
    }
}
