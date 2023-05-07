package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoCountCalculatorTest {
    @Test
    @DisplayName("주어진 금액으로 구매 가능한 로또 개수를 반환한다.")
    void 구매가능한_로또개수() {
        assertThat(LottoCountCalculator.calculateQuantity(10000)).isEqualTo(10);
    }

    @Test
    @DisplayName("거스름돈이 발생하는 경우 예외를 던진다.")
    void 거스름돈_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoCountCalculator.calculateQuantity(1500);
        });
    }
}
