package step2.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.LottoTestHelper;
import step2.lotto.LottoPrize;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultStatisticTest {

    @ParameterizedTest
    @DisplayName("")
    @CsvSource(value = {"3,3", "4,6", "5,2", "6,2"})
    void countOfMatches(long countOfMatches, long count) {
        LottoResults lottoResults = LottoTestHelper.generateLottoResults(countOfMatches,count);
        long expectedPrizeMoney = LottoPrize.getLottoPrize(countOfMatches).getPrizeMoney() * count;

        long sumOfPrizeMoney = lottoResults.sumOfPrizeMoney();

        assertEquals(expectedPrizeMoney, sumOfPrizeMoney);

    }
}