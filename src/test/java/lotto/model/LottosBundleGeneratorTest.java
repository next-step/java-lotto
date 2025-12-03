package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosBundleGeneratorTest {

    @Test
    @DisplayName("LottosBundleGenerator로 수동 로또와 자동 로또를 발급할 수 있다.")
    void generate() {
        LottosBundleGenerator generator = new LottosBundleGenerator(new Money(5000), List.of("1,2,3,4,5,6", "1,2,3,4,5,6"));
        assertThat(generator.generate().size()).isEqualTo(5);
    }
}