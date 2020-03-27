package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    void generate() {
        Lotto lotto = LottoGenerator.generate();

        assertThat(lotto.getNumbers()).hasSize(6);
    }
}
