package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuantityTest {

    @Test
    @DisplayName("수량이 0보다 작으면 예외를 던진다")
    void createQuantity_givenMinusInt_thenThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity(-1));
    }

    @Test
    @DisplayName("Quantity 생성 테스트")
    void createQuantity_givenPositiveInt() {
        assertThat(new Quantity(1)).isEqualTo(new Quantity(1));
    }
}