package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static domain.LottoNo.generateLottoNos;

public class LottoGameTest {

    private LottoGame lotto;

    @Test
    public void 구매금액으로_구매량을_구한다() {
        TestNumberGenerator generator = new TestNumberGenerator();
        List<LottoNo> attemptNumbers = generateLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6));
        generator.setRandomNumber(attemptNumbers);

        lotto = new LottoGame(new LottoAmount(14), new LottoAmount(0), generator);
        List<Attempt> lottoNumbers = lotto.getLottoNumbers();

        Assertions.assertThat(lottoNumbers).hasSize(14);
    }
}
