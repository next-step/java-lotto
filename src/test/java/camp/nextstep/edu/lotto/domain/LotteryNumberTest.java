package camp.nextstep.edu.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryNumberTest {
    @Test
    @DisplayName("1보다 작은 숫자를 입력하면 IllegalArgumentException 을 발생시켜야합니다")
    void constructor1() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LotteryNumber.from(0))
                .withMessageContaining("must be greater than or equal to");
    }

    @Test
    @DisplayName("1을 입력하면 정상적으로 LotteryNumber 가 생성되어야합니다")
    void constructor2() {
        final LotteryNumber actual = LotteryNumber.from(1);
        assertThat(actual).isInstanceOf(LotteryNumber.class);
    }

    @Test
    @DisplayName("45를 입력하면 정상적으로 LotteryNumber 가 생성되어야합니다")
    void constructor3() {
        final LotteryNumber actual = LotteryNumber.from(45);
        assertThat(actual).isInstanceOf(LotteryNumber.class);
    }

    @Test
    @DisplayName("45보다 큰 숫자를 입력하면 IllegalArgumentException 을 발생시켜야합니다")
    void constructor4() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LotteryNumber.from(46))
                .withMessageContaining("must be less than or equal to");
    }
}