package lotto;

import lotto.domain.BundleLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoCountManager;
import lotto.domain.generate.LottoAutoGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoGeneratorTest {

    @Test
    public void 로또발급() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        BundleLotto bundleLotto = new BundleLotto();
        bundleLotto.addLotto(Lotto.manual("32,38,2,4,13,6"));
        bundleLotto = lottoAutoGenerator.generate(new LottoCountManager(14000, 1), bundleLotto);
        assertThat(bundleLotto.getLottos().size()).isEqualTo(14);
    }

}