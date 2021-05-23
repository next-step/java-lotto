package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("입력받은돈은 양수만 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"오백원", "천원"})
    public void invalidAmountMoneyTest(String money) {
        assertThatThrownBy(() -> Money.create(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
