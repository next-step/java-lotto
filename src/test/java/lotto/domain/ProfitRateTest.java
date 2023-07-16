package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateTest {

    @Test
    @DisplayName("ProfitRate 클래스의 생성자는 양수 범위의 수익률이 들어오면 정상적으로 생성된다.")
    void create() {

        double profitRate = 0.35;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new ProfitRate(profitRate));
    }

    @Test
    @DisplayName("ProfitRate 클래스의 생성자는 0 미만의 수익률이 들어오면 예외를 던진다.")
    void createException() {

        double exceptionProfitRate = -0.35;

        Assertions.assertThatThrownBy(() -> new ProfitRate(exceptionProfitRate))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
