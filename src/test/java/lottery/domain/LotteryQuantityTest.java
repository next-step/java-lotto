package lottery.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LotteryQuantityTest {

    @Test
    @DisplayName("입력 값이 null 인 경우")
    public void nullInput() {
        // given
        String quantity = null;
        String message = "입력값은 null 일 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new LotteryQuantity(quantity);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력 값이 숫자가 아닌 경우")
    public void notNumber() {
        // given
        String quantity = "$";
        String message = "숫자가 아닙니다 -> " + quantity;

        // when
        ThrowingCallable throwingCallable = () -> new LotteryQuantity(quantity);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력 값이 음수인 경우 (String 입력)")
    public void negativeNumberStringInput() {
        // given
        String quantity = "-1";
        String message = "입력값은 0 보다 커야 합니다 -> " + quantity;

        // when
        ThrowingCallable throwingCallable = () -> new LotteryQuantity(quantity);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력 값이 음수인 경우 (Integer 입력)")
    public void negativeNumberIntegerInput() {
        // given
        int quantity = -2;
        String message = "입력값은 0 보다 커야 합니다 -> " + quantity;

        // when
        ThrowingCallable throwingCallable = () -> new LotteryQuantity(quantity);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("intStream 테스트")
    public void intStream() {
        // given
        LotteryQuantity lotteryQuantity = new LotteryQuantity(4);
        int expected = 4;

        // when
        IntStream lotteryQuantityStream = lotteryQuantity.intStream();

        // then
        assertThat(lotteryQuantityStream.count()).isEqualTo(expected);
    }

    @Test
    @DisplayName("isLessThan 테스트")
    public void isLessThan() {
        // given
        LotteryQuantity lotteryQuantity1 = new LotteryQuantity(4);
        LotteryQuantity lotteryQuantity2 = new LotteryQuantity(5);
        boolean expected = true;

        // when
        boolean lessThan = lotteryQuantity1.isLessThan(lotteryQuantity2);

        // then
        assertThat(lessThan).isEqualTo(expected);
    }
}