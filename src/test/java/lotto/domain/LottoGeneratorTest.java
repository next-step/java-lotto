package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void 로또_판매기_확인() {
        int value = 2000;
        LottoGenerator lottoGenerator = new LottoGenerator(value);
        assertThat(lottoGenerator).isNotNull();
    }

    @Test
    void 로또_구매금액_검증() {
        int value = 2500;
        assertThatThrownBy(() -> new LottoGenerator(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
