package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

    @DisplayName("당첨 결과에 따른 당첨 금액을 구한다")
    @ParameterizedTest
    @CsvSource(value = {"3,5000", "4,50000", "5,1500000", "6,2000000000"})
    public void findRank(int winningCount, int expectedReward) {
        //when
        LottoRank lottoRank = LottoRank.getLottoRank(winningCount);

        //then
        Assertions.assertEquals(expectedReward, lottoRank.reward());
    }
}
