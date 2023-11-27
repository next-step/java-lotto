package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void 생성() {
        LottoGenerator lottoGenerator = new LottoGenerator(14, new RandomLottoNumbers());
        assertThat(lottoGenerator.lottos().lottos()).hasSize(14);
    }
}