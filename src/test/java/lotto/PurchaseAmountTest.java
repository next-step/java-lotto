package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {
    @Test
    @DisplayName("PurchaseAmount는 1000원 미만 금액이 주어지면 유효한 금액을 입력하라는 예외를 던진다")
    void newObject_lessThan1000_throwsException() {
        assertThatThrownBy(
                () -> new PurchaseAmount(500)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("PurchaseAmount는 1000원 배수가 아닌 금액이 주어지면 유효한 금액을 입력하라는 예외를 던진다")
    void newObject_not1000multiple_throwsException() {
        assertThatThrownBy(
                () -> new PurchaseAmount(1500)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
