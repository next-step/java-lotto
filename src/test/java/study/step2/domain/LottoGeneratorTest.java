package study.step2.domain;

import org.junit.jupiter.api.Test;
import study.step2.Always1To6Numbers;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void 로또_번호_생성() {
        LottoGenerator generator = new LottoGenerator(new Always1To6Numbers());
        Lotto lotto = generator.generate();
        assertThat(lotto.lottoNumbers()).hasSize(6);
        assertThat(lotto.lottoNumbers()).contains(1);
        assertThat(lotto.lottoNumbers()).contains(2);
        assertThat(lotto.lottoNumbers()).contains(3);
        assertThat(lotto.lottoNumbers()).contains(4);
        assertThat(lotto.lottoNumbers()).contains(5);
        assertThat(lotto.lottoNumbers()).contains(6);
    }
}
