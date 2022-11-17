import domain.lottery.LotteryNumber;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LotteryNumberTest {

    @Test
    @Order(1)
    public void 유효하지_않은_로또넘버_1미만() {
        assertThatThrownBy(
                () -> LotteryNumber.of(0)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 번호입니다.");
    }

    @Test
    @Order(2)
    public void 유효하지_않은_로또넘버_45초과() {
        assertThatThrownBy(
                () -> LotteryNumber.of(46)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 번호입니다.");
    }

    @Test
    @Order(3)
    public void 유효한_로또넘버() {
        LotteryNumber numberOne = LotteryNumber.of(1);
        LotteryNumber numberTen = LotteryNumber.of(10);

        assertAll(
                () -> assertThat(numberOne.number()).isEqualTo(1),
                () -> assertThat(numberTen.number()).isEqualTo(10)
        );
    }

}
