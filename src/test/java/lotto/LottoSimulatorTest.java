package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoSimulatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14500:14", "0:0", "500:0", "5000:5", "15000000:15000"}, delimiter = ':')
    void LottoSimulator_금액별_로또_구매(int money, int expected) {
        LottoSimulator lottoSimulator = new LottoSimulator();
        lottoSimulator.buyingLotto(money);
        assertEquals(expected, lottoSimulator.getLottoCount());
    }
}