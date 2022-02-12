package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

    @DisplayName(value = "정수 자료형으로 Price 객체를 생성할때, Price의 값은 정수 자료형과 동일하다.")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 2_000, 3_000})
    void GivenMoneyWithIntType_WhenPriceGetValue_ThenEqualAsMoney(final int money) {
        final int PriceValue = Price.from(money).getValue();

        assertThat(PriceValue)
            .isEqualTo(money);
    }
}
