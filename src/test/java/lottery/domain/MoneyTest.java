package lottery.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("입력 값이 null 인 경우")
    public void nullInput() {
        // given
        String money = null;
        String message = "입력값은 null 일 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new Money(money);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력 값이 숫자가 아닌 경우")
    public void notNumber() {
        // given
        String money = "$";
        String message = "숫자가 아닙니다 -> " + money;

        // when
        ThrowingCallable throwingCallable = () -> new Money(money);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력 값이 음수인 경우 (String 입력)")
    public void negativeNumberStringInput() {
        // given
        String money = "-1";
        String message = "입력값은 0 보다 커야 합니다 -> " + money;

        // when
        ThrowingCallable throwingCallable = () -> new Money(money);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력 값이 음수인 경우 (Integer 입력)")
    public void negativeNumberIntegerInput() {
        // given
        int money = -2;
        String message = "입력값은 0 보다 커야 합니다 -> " + money;

        // when
        ThrowingCallable throwingCallable = () -> new Money(money);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

}