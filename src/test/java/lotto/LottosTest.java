package lotto;

import lotto.domain.Lottos;
import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottosTest {
    LottoGenerator autoLottoGenerator = new AutoLottoGenerator(1);

    @Test
    public void combine() {
        // given
        // when
        Lottos one = autoLottoGenerator.generateLottos();
        Lottos another = autoLottoGenerator.generateLottos();
        // then
        assertThat(Lottos.combine(one, another).getLottos()).containsOnly(one.getLottos().get(0), another.getLottos().get(0));
    }
}