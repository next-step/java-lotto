package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class LottoGameTest {

    private LottoGame lotto;

    @Test
    public void 구매금액으로_구매량을_구한다() {
        lotto = LottoGame.from(LottoAmount.from(14), LottoAmount.from(0), new TestNumberGenerator());
        List<Lotto> lottoNumbers = lotto.getLottoNumbers();

        Assertions.assertThat(lottoNumbers).hasSize(14);
    }
}
