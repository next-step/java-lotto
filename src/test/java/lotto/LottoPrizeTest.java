package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizeTest {

    @Test
    @DisplayName("일치하는 번호 개수에 따라 상금을 반환한다.")
    void shouldReturnCorrectPrizeBasedOnMatchCount() {
        assertThat(LottoPrize.getPrize(6)).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("일치하는 번호 개수가 0 ~ 6 이외의 값이면 예외가 발생한다.")
    void shouldThrowExceptionWhenMatchCountIsOutOfRange() {
        assertThatThrownBy(() -> LottoPrize.getPrize(7))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Invalid match count: 7");
    }

}
