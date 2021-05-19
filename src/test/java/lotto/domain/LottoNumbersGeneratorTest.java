package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("숫자값 6개 생성 테스트")
    void generate() {
        LottoNumbers generated = LottoNumbersGenerator.generate();

        assertThat(generated.getValue()).hasSize(6);
    }
}
