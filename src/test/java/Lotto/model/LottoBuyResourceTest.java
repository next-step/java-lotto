package Lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoBuyResourceTest {

    private static final int NORMAL_PRICE = 13000;
    private static final int NORMAL_MANUAL_LOTTO_COUNT = 2;
    private static final int MANUAL_LOTTO_COUNT_MINUS = -1;
    private static final int MANUAL_LOTTO_COUNT = 14;
    private static final int ERROR_PRICE = 123;

    @Test
    @DisplayName("정상적으로 생성되어지는지 확인테스트")
    public void constructorSuccessTest() {
        assertThat(new LottoBuyResource(NORMAL_PRICE, NORMAL_MANUAL_LOTTO_COUNT)).isEqualTo(new LottoBuyResource(NORMAL_PRICE, NORMAL_MANUAL_LOTTO_COUNT));
    }

    @Test
    @DisplayName("적절하지 않은 값으로 생성자 테스트")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> new LottoBuyResource(NORMAL_PRICE, MANUAL_LOTTO_COUNT_MINUS)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoBuyResource(NORMAL_PRICE, MANUAL_LOTTO_COUNT)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoBuyResource(ERROR_PRICE, NORMAL_MANUAL_LOTTO_COUNT)).isInstanceOf(IllegalArgumentException.class);
    }

}