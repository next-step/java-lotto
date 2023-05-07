package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class LottoGeneratorTest {

    @Test
    void generate() {
        assertThatNoException().isThrownBy(LottoGenerator::generate);
    }
}
