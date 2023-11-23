package step2;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.lotto.domain.LottoRank;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource({
        "6, FIRST, false",
        "5, SECOND, true",
        "5, THIRD, false",
        "4, FORTH, false",
        "3, FIFTH, false",
        "0, LOSE, false",
        "0, LOSE, true",
    })
    @DisplayName("일치하는 숫자 별로 로또의 등수를 반환한다.")
    void matchLottoRankMatchCount(int matchCount, LottoRank expectedRank, boolean isMatchBonus) {
        assertThat(LottoRank.valueOf(matchCount, isMatchBonus)).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @CsvSource({
        "1, FIRST, 2_000_000_000",
        "2, SECOND, 60_000_000",
        "3, THIRD, 4_500_000",
        "4, FORTH, 2_00_000",
        "5, FIFTH, 25_000",
        "6, LOSE, 0",
    })
    @DisplayName("등수 별 총 당첨 금액을 반환한다.")
    void lottoRankTotalPrizeAmountTest(int countOfScore, LottoRank lottoRank, int totalPrize) {
        assertThat(lottoRank.lottoRankTotalPrizeAmount(countOfScore)).isEqualTo(totalPrize);
    }
}
