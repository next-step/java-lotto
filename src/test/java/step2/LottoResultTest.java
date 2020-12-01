package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoResult;
import step2.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private List<Integer> lottoNumber;
    private WinningLotto winningLotto;

    @BeforeEach
    void init() {
        lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(7);
        lottoNumber.add(8);
        lottoNumber.add(9);

        List<Integer> winNumber = new ArrayList<>();
        winNumber.add(1);
        winNumber.add(2);
        winNumber.add(3);
        winNumber.add(4);
        winNumber.add(5);
        winNumber.add(6);
        winningLotto = new WinningLotto(winNumber);
    }

    @Test
    public void 당첨확인() {
        Lotto lotto = new Lotto(lottoNumber);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);

        assertThat(lottoResult.getRanks().size()).isEqualTo(1);
    }

    @Test
    public void 총수익률() {
        Lotto lotto = new Lotto(lottoNumber);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);

        assertThat(lottoResult.getTotalRevenue(1000)).isEqualTo(5.0);
    }
}
