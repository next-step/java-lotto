package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottosGeneratorTest {
    @Test
    @DisplayName("수동 로또 생성")
    void generateManualLotto() {
        Lottos lottos = LottosGenerator.generate(new Positive(0), Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));
        assertThat(new Lottos(Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"))).isEqualTo(lottos);
    }

    @Test
    @DisplayName("전체 로또 생성")
    void generateLotto() {
        Lottos lottos = LottosGenerator.generate(new Positive(3), Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}
