package lotto.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberStrategyTest {

    private NumberStrategy numberStrategy;

    @BeforeEach
    void setUp() {
        numberStrategy = new RandomNumberStrategy();
    }

    @DisplayName("랜덤 숫자 발급 1~45 사이")
    @Test
    void 랜덤_숫자_발급() {
        // given
        // when
        int number = numberStrategy.create();
        // then
        assertThat(number).isGreaterThanOrEqualTo(1);
        assertThat(number).isLessThanOrEqualTo(45);
    }
}
