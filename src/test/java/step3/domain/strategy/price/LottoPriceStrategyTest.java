package step3.domain.strategy.price;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.strategy.lotto.LottoPolicyStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoPriceStrategyTest {
    LottoPriceStrategy lottoPriceStrategy;

    @BeforeEach
    void setLottoPolicyStrategy() {
        this.lottoPriceStrategy = new LottoPriceStrategy();
    }

    @Test
    void buyManualLotto() {
        assertThatThrownBy(() -> lottoPriceStrategy.buyManualLotto(14000, 50))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
