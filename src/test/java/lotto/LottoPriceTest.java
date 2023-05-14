package lotto;

import lotto.domain.LottoPrice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoPriceTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 500, 999})
    void _1000원_미만시_로또를_구매할수없음(int input) {
        assertThatThrownBy(() -> new LottoPrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 비용이 부족합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000})
    void _1000원_이상시_로또를_구매할수있음(int input) {
        assertThatCode(() -> new LottoPrice(input))
                .doesNotThrowAnyException();
    }
}
