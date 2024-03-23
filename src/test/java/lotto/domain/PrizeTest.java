package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @DisplayName("당첨 번호랑 일치하는 갯수가 3개 ~ 6개에 포함되지 않을 때 false를 반환한다")
    @Test
    void contains_prize() {
        assertThat(Prize.NONE.containsPrize()).isFalse();
    }

    @Test
    void no_prize() {
        assertThat(Prize.valueOf(0)).isEqualTo(Prize.NONE);
    }

    @Test
    void fourth_prize() {
        assertThat(Prize.valueOf(3)).isEqualTo(Prize.FOURTH_PRIZE);
    }

    @Test
    void third_prize() {
        assertThat(Prize.valueOf(4)).isEqualTo(Prize.THIRD_PRIZE);
    }

    @Test
    void second_prize() {
        assertThat(Prize.valueOf(5)).isEqualTo(Prize.SECOND_PRIZE);
    }

    @Test
    void first_prize() {
        assertThat(Prize.valueOf(6)).isEqualTo(Prize.FIRST_PRIZE);
    }

    @Test
    void Prize_enum() {
        assertThat(Prize.FIRST_PRIZE == Prize.FIRST_PRIZE).isTrue();
    }

}
