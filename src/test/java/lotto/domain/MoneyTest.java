package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1001})
    @DisplayName("lotto 구매 금액 테스트")
    void lottoMoney(int num) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {new Money(num);});
    }

}