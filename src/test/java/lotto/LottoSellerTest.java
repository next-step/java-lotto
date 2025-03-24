package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoSellerTest {
    private final LottoSeller lottoSeller = new LottoSeller();

    @ParameterizedTest(name = "입력한 금액으로 살 수 있는 로또의 장 수를 계산한다. 입력 금액: {0}")
    @CsvSource({
            "1000, 1",
            "2000, 2",
            "3500, 3",
            "14000, 14"
    })
    void lottoCountTest(int input, int expected) {
        assertEquals(expected, lottoSeller.getPurchasableLottoCount(new Money(input)));
    }
}
