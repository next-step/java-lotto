package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeResultEnumTest {

    @ParameterizedTest(name = "매칭된 숫자 개수 : {0}, 우승 상금 : {1}, 보너스 볼 여부 : {2}")
    @EnumSource(value = PrizeEnum.class)
    void testPrizeEnum_ValidPrizeEnumInput_ShouldReturnValidPrize(PrizeEnum prizeInput) {
        // given, when
        PrizeEnum prize = PrizeEnum.getPrizeFrom(prizeInput.getMatchedCount(), prizeInput.isBonusMatched());
        Long prizeAmount = prize.getPrize();

        // then
        assertEquals(prizeInput.getPrize(), prizeAmount);
    }

    @Test
    @DisplayName("PrizeResultEnum에 존재하지 않는 matchedCount로 조회시 prize는 0L로 반환")
    void testGetPrizeByIndex_NoneExistingMatchedCount_ShouldReturnZeroAndNull() {
        // given
        int matchedCount = 0;
        boolean isBonusMatched = true;

        // when
        PrizeEnum prize = PrizeEnum.getPrizeFrom(matchedCount, isBonusMatched);
        Long prizeAmount = prize.getPrize();

        // then
        assertEquals(prizeAmount, 0);
    }

    @ParameterizedTest(name = "matchedCount로 isBonusMatched를 조회")
    @CsvSource(value = {"6:false", "5:true", "4:false", "3:false", "0:false"}, delimiter = ':')
    void testIsBonusMatchedFrom_ShouldReturnIsBonusMatched(int matchedCount, boolean isBonusMatched) {
        // then
        assertEquals(PrizeEnum.isBonusMatchedFrom(matchedCount), isBonusMatched);
    }
}