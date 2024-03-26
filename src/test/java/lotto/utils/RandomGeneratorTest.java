package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomGeneratorTest {

    @Test
    @DisplayName("로또 번호는 1~45 사이")
    void num_of_lotto_element() {
        RandomGenerator randomGenerator = new RandomGenerator();

        assertThat(randomGenerator.genRandomNum()>0 && randomGenerator.genRandomNum() <=45).isEqualTo(true);
    }
}
