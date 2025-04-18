package step3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.LottoOrder;

public class LottoOrderTest {
    @ParameterizedTest
    @CsvSource({
        "1000, 1",
        "14000, 14"
    })
    @DisplayName("로또 가격별 발행 테스트 - 금액의 배수인 경우")
    public void buyLottoTest(int price, int expected) {
        LottoOrder lottoOrder = new LottoOrder(price);
        assertEquals(expected, lottoOrder.lottos().size());
    }

    @ParameterizedTest
    @CsvSource({
        "8500, 8"
    })
    @DisplayName("로또 가격별 발행 테스트 - 금액의 배수가 아닌 경우")
    void buyLottoTest2(int price, int expected) {
        LottoOrder lottoOrder = new LottoOrder(price);
        assertEquals(expected, lottoOrder.lottos().size());
    }
}
