package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto lotto;
    private LottoMachine lottoMachine;

    @BeforeEach
    public void init() {
        List<LottoNumber> lottoNumbers =
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(15));
        List<LottoNumber> winningLottoNumbers =
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(8), new LottoNumber(9), new LottoNumber(10));
        this.lotto = new Lotto(lottoNumbers);
        this.lottoMachine = new LottoMachine(winningLottoNumbers, 15);
    }

    @Test
    public void 로또_한_장당_당첨_번호_일치_개수를_반환함() {
        Assertions.assertThat(lotto.compareLottoAndWinnerNumbers(lottoMachine)).isEqualTo(3);
    }

    @Test
    public void 로또_한_장당_보너스_일치_개수를_반환함() {
        Assertions.assertThat(lotto.compareLottoAndBonusNumbers(lottoMachine)).isEqualTo(1);
    }
}
