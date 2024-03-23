package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeResultEnumTest {

    @ParameterizedTest(name = "매칭된 숫자 개수 : {0}, 우승 상금 : {1}")
    @CsvSource({
            "3, 5000",
            "4, 50000",
            "5, 1500000",
            "6, 2000000000"
    })
    void testGetDescriptionByIndex_ValidIndex_ShouldReturnValidResult(int matchedNumber, Long expectedPrize) {
        // given, when
        Long prize = PrizeResultEnum.getPrizeByMatchedCount(matchedNumber);

        // then
        assertEquals(expectedPrize, prize);
    }

    @Test
    @DisplayName("PrizeResultEnum에 존재하지 않는 index로 조회시 prize는 0L로 반환")
    void testGetPrizeByIndex_NoneExistingIndex_ShouldReturnZeroAndNull() {
        // given
        int index = 0;

        // when
        Long prize = PrizeResultEnum.getPrizeByMatchedCount(index);

        // then
        assertEquals(prize, 0);
    }
}