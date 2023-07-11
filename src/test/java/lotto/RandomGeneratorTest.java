package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void generate() {
        Assertions.assertThatNoException()
                .isThrownBy(RandomGenerator::generateLotto);
    }
}