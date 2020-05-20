package lotto.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGenerationStrategyTest {

    @DisplayName("1 ~ 45 사이의 6개의 숫자를 랜덤으로 생성")
    @Test
    void generate() {
        assertThat(new RandomGenerationStrategy(6).generate().size()).isEqualTo(6);
    }
}
