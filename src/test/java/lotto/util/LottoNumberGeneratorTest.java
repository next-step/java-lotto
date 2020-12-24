package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @Test
    void createLotto() {
        System.out.println(LottoNumberGenerator.makeLottoNumber());
        assertThat(LottoNumberGenerator.makeLottoNumber().size()).isEqualTo(6);
    }
}