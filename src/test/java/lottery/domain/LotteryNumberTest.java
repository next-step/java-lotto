package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryNumberTest {

    @DisplayName("정해진 범위를 벗어난 숫자는 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    void throwExceptionIfIntegerIsOutOfRange(int number) {
        assertThatThrownBy(() -> new LotteryNumber(number)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("같은 숫자를 가진 두 인스턴스를 비교하면 true 여야 한다.")
    void equals() {
        LotteryNumber lotteryNumber1 = new LotteryNumber(20);
        LotteryNumber lotteryNumber2 = new LotteryNumber(20);

        assertThat(lotteryNumber1.equals(lotteryNumber2)).isTrue();
    }
}
