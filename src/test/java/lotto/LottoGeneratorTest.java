package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    void generate() {
        assertThat(LottoGenerator.generate(1_000)).isNotEmpty();
    }
}
