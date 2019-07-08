package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoWin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    static public int COUNT_OF_CORRECT_NUMBER = 3;

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottoResult.add(LottoWin.valueOf(COUNT_OF_CORRECT_NUMBER, false));
    }

    @Test
    void 특정개수맞춘티켓에대한_정보를_출력한다() {
        assertThat(lottoResult.getResultOf(LottoWin.FIFTH)).isEqualTo("3개 일치 (5000원) - 1개");
    }

    @Test
    void 보너스볼에대한_결과정보를_출력한다() {
        lottoResult = new LottoResult();
        lottoResult.add(LottoWin.valueOf(5, true));
        assertThat(lottoResult.getResultOf(LottoWin.SECOND)).isEqualTo("5개 일치, 보너스 볼 일치 (30000000원) - 1개");
    }

    @Test
    void 수익률() {
        assertThat(lottoResult.getProfitRate()).isEqualTo(5);
    }
}
