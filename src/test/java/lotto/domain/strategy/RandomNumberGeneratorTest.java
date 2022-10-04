package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    private NumberGeneratable generator;

    @BeforeEach
    void setUp() {
        generator = new RandomNumberGenerator();
    }

    @DisplayName("0 보다 크고 45 이하인 번호 6개를 오름차순으로 정렬하여 생성한다.")
    @Test
    void createNumbers() {
        assertThat(generator.generate()).hasSize(6).isSorted().allSatisfy(number -> assertThat(number).isBetween(1, 45));
    }
}
