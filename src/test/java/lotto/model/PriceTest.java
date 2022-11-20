package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {

    @Test
    @DisplayName("구매금액은 최소 1000원이상")
    void valid1() {
        assertThatThrownBy(() -> new Price(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매금액은 1000원 단위이다")
    void valid2() {
        assertThatThrownBy(() -> new Price(1002))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 개수는 음수가 될수없다")
    void valid3() {
        assertThatThrownBy(() -> new Price(3000).manualValidation(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동 로또개수는 구매금액을 넘을수 없다")
    void valid4() {
        assertThatThrownBy(() -> new Price(3000).manualValidation(4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}