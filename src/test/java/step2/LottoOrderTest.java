package step2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.domain.LottoOrder;

public class LottoOrderTest {
    @ParameterizedTest
    @CsvSource({
        "1000, 1",
        "14000, 14",
        "8500, 8" // 금액 안되면 버려야함
    })
    @DisplayName("로또 가격별 발행 테스트")
    public void buyLottoTest(int price, int expected) {
        LottoOrder lottoOrder = new LottoOrder(price);
        assertEquals(expected, lottoOrder.getLottoList().size());
    }
}
