package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeResultEnumTest {

    @ParameterizedTest(name = "[{index}] 인덱스 : {0}, 예상 Description : {1}, 우승 상금 : {2}")
    @CsvSource({
            "3, '3개 일치 (5,000원) - ', 5000",
            "4, '4개 일치 (50,000원) - ', 50000",
            "5, '5개 일치 (1,500,000원) - ', 1500000",
            "6, '6개 일치 (2,000,000,000원) - ', 2000000000"
    })
    void testGetDescriptionByIndex_ValidIndex_ShouldReturnValidResult(int index, String expectedDescription, Long expectedPrize) {
        // given, when
        String description = PrizeResultEnum.getDescriptionByIndex(index);
        Long prize = PrizeResultEnum.getPrizeByIndex(index);

        // then
        assertEquals(expectedDescription, description);
        assertEquals(expectedPrize, prize);
    }

    @Test
    @DisplayName("PrizeResultEnum에 존재하지 않는 index로 조회시 prize는 0L, description을 null로 반환")
    void testGetPrizeByIndex_NoneExistingIndex_ShouldReturnZeroAndNull() {
        // given
        int index = 0;

        // when
        String description = PrizeResultEnum.getDescriptionByIndex(index);
        Long prize = PrizeResultEnum.getPrizeByIndex(index);

        // then
        assertEquals(description, null);
        assertEquals(prize, 0);
    }
}