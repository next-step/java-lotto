package step2.domain;

import org.junit.jupiter.api.Test;
import step2.model.Lotto;
import step2.model.LottoResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoGeneratorTest {

    @Test
    public void 로또_생성_시_숫자_6개_리스트를_반환한다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoResult lottoResult = lottoGenerator.getLottos(1);

        assertThat(lottoResult.size()).isEqualTo(1);
        Lotto lotto = lottoResult.getLottoResults().get(0);

        assertThat(lotto.getLottoNumbers()).hasSize(6);
        lotto.getLottoNumbers().forEach(ball -> {
            assertThat(ball).isBetween(1, 45);
        });
    }
}
