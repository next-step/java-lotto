package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    void lotto_generate_size() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.generate()).hasSize(6);
    }
}