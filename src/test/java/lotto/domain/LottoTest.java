package lotto.domain;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    public void 로또_한_장당_당첨_번호_일치_개수를_반환함() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoMachine lottoMachine = new LottoMachine(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
        Assertions.assertThat(lotto.compareLottoAndWinnerNumbers(lottoMachine)).isEqualTo(4);
    }

    @Test
    public void 로또_한_장당_보너스_일치_개수를_반환함() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoMachine lottoMachine = new LottoMachine(Arrays.asList(3, 4, 5, 6, 7, 8), 1);
        Assertions.assertThat(lotto.compareLottoAndBonusNumbers(lottoMachine)).isEqualTo(1);
    }
}