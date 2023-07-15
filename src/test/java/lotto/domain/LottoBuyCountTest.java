package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBuyCountTest {

    @Test
    @DisplayName("수동으로 구매할 로또 수 생성 테스트")
    void manualBuyCount_create() {
        assertDoesNotThrow(() -> new LottoBuyCount("10"));
    }

    @Test
    @DisplayName("음수가 입력되는 경우")
    void manualBuyCount_negative() {
        assertThrows(IllegalArgumentException.class,
                () -> new LottoBuyCount("-1")
        );
    }

    @Test
    @DisplayName("문자열이 입력되는 경우 테스트")
    void manualBuyCount_notNumeric() {
        assertThrows(IllegalArgumentException.class,
                () -> new LottoBuyCount("Hello")
        );
    }

    @Test
    @DisplayName("구매 개수가 구매 후 감소하는지 테스트")
    void manualBuyCount_decrease() {
        assertThat(new LottoBuyCount("10").decrease()).isEqualTo(new LottoBuyCount("9"));
    }

    @Test
    @DisplayName("구매 개수를 다 감소 후 isZero 메서드 테스트")
    void manualBuyCount_isZero() {
        assertThat(new LottoBuyCount("1").decrease().isZero()).isTrue();
        assertThat(new LottoBuyCount("2").decrease().isZero()).isFalse();
    }
}
