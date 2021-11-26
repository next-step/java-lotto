package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("lotto 생성시 6개의 숫자만 뽑히는지 검증")
    @Test
    void lottoCountTest() {
        assertThat(LottoNumberGenerator.generate().size()).isEqualTo(6);
    }
}
