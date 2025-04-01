package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lottery.LotteryNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryNumberTest {
    @Test
    @DisplayName("로또 번호가 1 이하인 경우, 예외를 발생한다.")
    void notRangeLottoNumberTest() {
        assertThatThrownBy(() -> {
            LotteryNumber number = new LotteryNumber(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 45 이상인 경우, 예외를 발생한다.")
    void notRangeLottoNumberTest2() {
        assertThatThrownBy(() -> {
            LotteryNumber number = new LotteryNumber(46);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 1 이상 45 이하인 경우, 로또 번호를 생성한다.")
    void createLottoNumberTest() {
        LotteryNumber number = new LotteryNumber(1);
        assertThat(number).isEqualTo(new LotteryNumber(1));
    }
}
