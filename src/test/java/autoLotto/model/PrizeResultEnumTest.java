package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeEnumTest {

    @ParameterizedTest(name = "매칭된 숫자 개수 : {0}, 우승 상금 : {1}, 보너스 볼 여부 : {2}")
    @CsvSource({
            "6, 2000000000, false",
            "5, 30000000, true",
            "5, 1500000, false",
            "4, 50000, false",
            "3, 5000, false",
            "0, 0, false"
    })
    void testPrizeEnum_ValidMatchedCountAndIsBonusMatched_ShouldReturnValidPrize(int matchedNumber, Long expectedPrize, boolean isBonusMatched) {
        // given, when
        PrizeEnum prize = PrizeEnum.getPrizeFrom(matchedNumber, isBonusMatched);
        Long prizeAmount = prize.getPrize();

        // then
        assertEquals(expectedPrize, prizeAmount);
    }

    @Test
    @DisplayName("PrizeResultEnum에 존재하지 않는 index로 조회시 prize는 0L로 반환")
    void testGetPrizeByIndex_NoneExistingIndex_ShouldReturnZeroAndNull() {
        // given
        int matchedCount = 0;
        boolean isBonusMatched = true;

        // when
        PrizeEnum prize = PrizeEnum.getPrizeFrom(matchedCount, isBonusMatched);
        Long prizeAmount = prize.getPrize();

        // then
        assertEquals(prizeAmount, 0);
    }
}