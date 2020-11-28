package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private List<Integer> lottoNumber;
    private int[] winNumber = new int[]{1, 2, 3, 4, 5, 6};

    @BeforeEach
    void init() {
        lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(7);
        lottoNumber.add(8);
        lottoNumber.add(9);
    }

    @Test
    public void 당첨확인() {
        Lotto lotto = new Lotto(lottoNumber);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        LottoResult lottoResult = new LottoResult(winNumber, lottoList);

        assertThat(lottoResult.getRanks().size()).isEqualTo(1);
    }

    @Test
    public void 총수익률() {
        Lotto lotto = new Lotto(lottoNumber);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        LottoResult lottoResult = new LottoResult(winNumber, lottoList);

        assertThat(lottoResult.getTotalRevenue(1000)).isEqualTo(5.0);
    }
}
