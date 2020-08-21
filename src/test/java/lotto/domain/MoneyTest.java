package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @DisplayName("1000원 이하 금액 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-10, 10, 500, 900})
    void lessThanLottoPriceTest(int price) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.of(price));
    }
}