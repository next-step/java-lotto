package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoWin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;
    private List<LottoWin> wins;

    @Test
    void 특정개수맞춘티켓에대한_정보를_출력한다() {
        wins = Arrays.asList(LottoWin.valueOf(3, false));
        lottoResult = LottoResult.of(wins);
        assertThat(lottoResult.getResultOf(LottoWin.FIFTH)).isEqualTo(1);
    }

    @Test
    void 보너스볼에대한_결과정보를_출력한다() {
        wins = Arrays.asList(LottoWin.valueOf(5, true));
        lottoResult = LottoResult.of(wins);
        assertThat(lottoResult.getResultOf(LottoWin.SECOND)).isEqualTo(1);
    }

    @Test
    void 수익률() {
        wins = Arrays.asList(LottoWin.valueOf(3, false));
        lottoResult = LottoResult.of(wins);
        assertThat(lottoResult.getProfitRate()).isEqualTo(5);
    }
}
