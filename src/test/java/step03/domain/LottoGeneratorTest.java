package step03.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("로또가 shuffled 됐는지 테스트--버그")
    @Test
    void test_generate() {
        assertThat(LottoGenerator.generate().toString())
                .isNotEqualTo(LottoGenerator.generate().toString());
    }
}
