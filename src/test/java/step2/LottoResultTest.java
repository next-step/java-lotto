package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private List<LottoNumber> lottoNumber;
    private List<LottoNumber> winningLottoNumber;
    private Lotto lotto;
    private Lotto winningLotto;
    private List<Lotto> buyLotto = new ArrayList<>();

    @BeforeEach
    void init() {
        lottoNumber = new ArrayList<>();
        lottoNumber.add(LottoNumber.of(1));
        lottoNumber.add(LottoNumber.of(2));
        lottoNumber.add(LottoNumber.of(3));
        lottoNumber.add(LottoNumber.of(7));
        lottoNumber.add(LottoNumber.of(8));
        lottoNumber.add(LottoNumber.of(9));
        lotto = new Lotto(lottoNumber);
        buyLotto.add(lotto);

        winningLottoNumber = new ArrayList<>();
        winningLottoNumber.add(LottoNumber.of(1));
        winningLottoNumber.add(LottoNumber.of(2));
        winningLottoNumber.add(LottoNumber.of(3));
        winningLottoNumber.add(LottoNumber.of(4));
        winningLottoNumber.add(LottoNumber.of(5));
        winningLottoNumber.add(LottoNumber.of(6));
        winningLotto = new Lotto(winningLottoNumber);
    }

    @Test
    public void 당첨확인() {
        LottoResult lottoResult = new LottoResult(winningLotto, buyLotto);

        assertThat(lottoResult.getRanks().size()).isEqualTo(1);
    }

    @Test
    public void 총수익률() {
        LottoResult lottoResult = new LottoResult(winningLotto, buyLotto);

        assertThat(lottoResult.getTotalRevenue(14000)).isEqualTo(BigDecimal.valueOf(0.35));
    }
}
