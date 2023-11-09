package lotto.strategy;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        List<Lotto> number = numberStrategy.create(1);
        // then
        assertThat(number.get(0).lottoNumbers()).hasSize(6);
    }
}
