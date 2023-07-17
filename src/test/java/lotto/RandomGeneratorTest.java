package lotto;

import lotto.util.RandomGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤하게 로또를 자동 생성한다.")
    void generate() {
        RandomGenerator randomGenerator = new RandomGenerator();
        Assertions.assertThatNoException()
                .isThrownBy(randomGenerator::generateAutoLotto);
    }
}