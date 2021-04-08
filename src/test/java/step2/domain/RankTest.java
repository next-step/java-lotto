package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.IllegalLottoResultCount;


import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("팩토리메소드 정상생성")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void FactoryTest(int value) {
        assertDoesNotThrow(() -> Rank.of(value));
    }

    @DisplayName("팩토리메소드 익셉션 발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9})
    void FactoryExceptionTest(int value) {
        assertThrows(IllegalLottoResultCount.class, () -> LottoMatchResultCount.of(value));
    }

    @DisplayName("cash 일치하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getMatchResultsMessageTest(int value, int cash) {

        int rewardCash = LottoMatchResultCount.of(value).getRewardCash();
        assertEquals(rewardCash, cash);
    }
}