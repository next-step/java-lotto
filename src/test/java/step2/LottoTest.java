package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoMachine;
import step2.domain.LottoResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 구매갯수계산() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.buyLotto(14000).size()).isEqualTo(14);
    }

    @Test
    public void 당첨확인() {
        LottoResult lottoResult = new LottoResult();
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(7);
        lottoNumber.add(8);
        lottoNumber.add(9);
        Lotto lotto = new Lotto(lottoNumber);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        int[] winNumber = new int[]{1, 2, 3, 4, 5, 6};
        int[][] winCounts = lottoResult.getWin(winNumber, lottoList);

        assertThat(winCounts[0][0]).isEqualTo(1);
    }

    @Test
    public void 총수익률() {
        LottoResult lottoResult = new LottoResult();
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(7);
        lottoNumber.add(8);
        lottoNumber.add(9);
        Lotto lotto = new Lotto(lottoNumber);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        int[] winNumber = new int[]{1, 2, 3, 4, 5, 6};
        int[][] winCounts = lottoResult.getWin(winNumber, lottoList);

        assertThat(lottoResult.getTotalRevenue(1000, winCounts)).isEqualTo(500.0);
    }
}
