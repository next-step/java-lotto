package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PriceTest {

    @Test
    @DisplayName("입력 금액이 로또 금액보다 작으면 예외를 발생시킨다.")
    void when_InputIsLessThanLotteryPrice_ThrowsException() {

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Price(0));
    }
}