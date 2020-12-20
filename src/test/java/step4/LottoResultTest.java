package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();
    private List<Lotto> buyLottoList = new ArrayList<>();
    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    void init() {
        lottoNumbers.add(LottoNumber.of(1));
        lottoNumbers.add(LottoNumber.of(2));
        lottoNumbers.add(LottoNumber.of(3));
        lottoNumbers.add(LottoNumber.of(4));
        lottoNumbers.add(LottoNumber.of(5));
        lottoNumbers.add(LottoNumber.of(6));

        lotto = new Lotto(lottoNumbers);
        buyLottoList.add(lotto);
        winningLotto = new WinningLotto(new Lotto(lottoNumbers), LottoNumber.of(7));
    }

    @Test
    void LottoResult() {
        assertThat(new LottoResult(winningLotto, buyLottoList)).isEqualTo(Rank.FIRST);
    }

    @Test
    void getTotalRevenue() {
        assertThat(new LottoResult(winningLotto, buyLottoList).getTotalRevenue(3000)).isEqualTo(BigDecimal.valueOf(666666.66));
    }
}
