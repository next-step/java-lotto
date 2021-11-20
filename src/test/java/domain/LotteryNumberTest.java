package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LotteryNumberTest {

    @Test
    @DisplayName("로또번호 1이상 45미만 생성")
    public void createLotteryNumber() {
        Assertions.assertAll(
                () -> assertThat(new LotteryNumber(1).value()).isEqualTo(1),
                () -> assertThat(new LotteryNumber(45).value()).isEqualTo(45)
        );
    }

    @Test
    @DisplayName("로또번호는 1보다 작을수 없다.")
    public void validLotteryNumberMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LotteryNumber(0);

            fail("로또번호 에러가 발생해야 한다.");
        });
    }

    @Test
    @DisplayName("로또번호는 45보다 클수 없다.")
    public void validLotteryNumberMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LotteryNumber(46);

            fail("로또번호 에러가 발생해야 한다.");
        });
    }

}
