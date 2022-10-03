package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class LottoSellerTest {

    @ParameterizedTest
    @CsvSource({
        "1000, 1",
        "3000, 3",
        "238000, 238",
    })
    @DisplayName("가격에 맞는 로또 개수를 구매를 했는지 검증")
    void sellLottoCount(int price, int size) {
        then(LottoSeller.sell(price).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, 1, 999, 1500})
    @DisplayName("입력한 금액 validate 테스트")
    void validatePriceFail(int price) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoSeller.sell(price));
    }
}