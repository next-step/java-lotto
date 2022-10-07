package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.*;

class RandomGeneratorTest {

    @DisplayName("범위 내 번호가 생성된다.")
    @RepeatedTest(100)
    void set() {
        int number = RandomGenerator.randomNumber(1, 10);

        assertThat(number).isBetween(1, 10);
    }
}