package model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("금액이 1원보다 적은 경우에는 예외가 발생한다.")
    public void init(int value) {
        assertThatThrownBy(() -> new Price(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("인자값으로 넘긴 변수와의 퍼센트를 구한다.")
    public void getPercentOf() {
        Price price = new Price(100);
        assertEquals(price.getPercentOf(100), 1);
    }
}