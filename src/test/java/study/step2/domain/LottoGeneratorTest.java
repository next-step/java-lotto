package study.step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void 로또_번호_생성() {
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.generate();
        assertThat(lotto.lottoNumbers()).hasSize(6);
    }
}
