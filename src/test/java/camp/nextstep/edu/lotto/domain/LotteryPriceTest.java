package camp.nextstep.edu.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryPriceTest {

    @Test
    @DisplayName("구매할 수 있는 로또의 개수를 반환합니다")
    void calculate() {
        int actual = LotteryPrice.calculateAvailableLottery(14000);
        assertThat(actual).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 금액보다 적은 금액을 입력하면, 0을 반환합니다")
    void calculate_zero() {
        int actual = LotteryPrice.calculateAvailableLottery(999);
        assertThat(actual).isEqualTo(0);
    }

}