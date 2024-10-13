package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoGeneratorTest {

    @Test
    public void 로또_생성_시_숫자_6개_리스트를_반환한다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.getLottos(1);

        assertThat(lottos.size()).isEqualTo(1);
        Lotto lotto = lottos.getLottos().get(0);

        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }
}
