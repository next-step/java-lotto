package step4;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step4.domain.LottoOrder;

public class LottoOrderTest {
    @ParameterizedTest
    @CsvSource({
        "1000, 1",
        "14000, 14"
    })
    @DisplayName("로또 가격별 발행 테스트 - 금액의 배수인 경우")
    public void buyLottoTest(int price, int expected) {
        LottoOrder lottoOrder = LottoOrder.ofAuto(price);
        assertEquals(expected, lottoOrder.size());
    }

    @ParameterizedTest
    @CsvSource({
        "8500, 8"
    })
    @DisplayName("로또 가격별 발행 테스트 - 금액의 배수가 아닌 경우")
    void buyLottoTest2(int price, int expected) {
        LottoOrder lottoOrder = LottoOrder.ofAuto(price);
        assertEquals(expected, lottoOrder.size());
    }

    @Test
    @DisplayName("로또 구매 시 전체 가격은 수동 구매 후 나머지 자동금액의 합과 같아야 한다.")
    void buyLottoWithManual() {
        List<String> boughtLottos = List.of(
            "1,2,3,4,5,6",
            "2,3,4,5,6,7",
            "3,4,5,6,7,8"
        );
        LottoOrder lottoOrder = LottoOrder.ofCombined(14000, boughtLottos);
        assertThat(lottoOrder.size()).isEqualTo(LottoOrder.ofAuto(14000).size());
    }
}
