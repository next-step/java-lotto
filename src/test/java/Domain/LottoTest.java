package Domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class LottoTest {

    private Lotto lotto;

    @Test
    public void 구매금액으로_구매량을_구한다() {
        lotto = new Lotto(14, new TestNumberGenerator());
        List<Attempt> lottoNumbers = lotto.getLottoNumbers();

        Assertions.assertThat(lottoNumbers).hasSize(14);
    }
}
