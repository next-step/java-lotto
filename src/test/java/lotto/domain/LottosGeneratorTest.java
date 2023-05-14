package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottosGeneratorTest {
    @Test
    @DisplayName("생성")
    void generate() {
        Lottos lottos = LottosGenerator.generate(Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));
        assertThat(new Lottos(Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"))).isEqualTo(lottos);
    }
}
