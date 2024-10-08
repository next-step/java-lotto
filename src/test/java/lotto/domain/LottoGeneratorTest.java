package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void 로또_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = lottoGenerator.generateLotto();
        assertThat(lotto).isNotNull();
    }
}