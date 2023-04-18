package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryNumberTest {

    @Test
    @DisplayName("로또 번호를 생성한다")
    void create() {
        // given
        int number = 1;

        // when
        LotteryNumber lotteryNumber = new LotteryNumber(number);

        // then
        assertThat(lotteryNumber).isNotNull();
        assertThat(lotteryNumber).isEqualTo(new LotteryNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 46})
    @DisplayName("로또 번호를 생성할 때 1~45 사이의 숫자가 아니면 예외를 발생시킨다")
    void createException(int number) {
        // when
        assertThatThrownBy(() -> new LotteryNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1~45 사이의 숫자만 가능합니다.");
    }
}