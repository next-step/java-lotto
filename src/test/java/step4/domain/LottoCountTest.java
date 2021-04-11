package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.exception.IllegalLottoCountException;

import static org.junit.jupiter.api.Assertions.*;

class LottoCountTest {

    @DisplayName("lottoCount 테스트 - 수동구매갯수가 총 로또구매갯수를 넘었을경우")
    @ParameterizedTest
    @CsvSource(value = {"1000:2", "1000:3", "0:1", "2000:4", "3000:5"}, delimiter = ':')
    void countOfUserLottoTest(int cash, int purchaseAmountOfUserLotto) {
        assertThrows(IllegalLottoCountException.class, () -> new LottoCount(cash, purchaseAmountOfUserLotto));
    }

    @DisplayName("lottoCount 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1:0", "1000:0:1", "0:0:0", "2000:0:2", "3000:1:2"}, delimiter = ':')
    void lottoCountTest(int cash, int purchaseAmountOfUserLotto, int expectedCount) {
        LottoCount lottoCount = new LottoCount(cash, purchaseAmountOfUserLotto);
        assertEquals(lottoCount.getLottoCount(), expectedCount);
    }

}