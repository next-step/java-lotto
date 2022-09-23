package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @DisplayName("1 이상 45 이하의 랜덤한 숫자 생성")
    @RepeatedTest(1000)
    void random() {
        int number = RandomNumberGenerator.generate(1, 45);

        assertThat(number).isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(45);
    }
}
