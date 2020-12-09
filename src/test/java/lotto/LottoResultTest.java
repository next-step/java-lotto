package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    public void setUp() {
        lottoResult = new LottoResult(1);
    }

    @Test
    @DisplayName("로또 결과가 저장")
    public void save_lotto_result_() {
        LottoResult.saveLottoResult(3, true);
        assertThat(lottoResult.getResult().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산")
    public void get_profit_ratio() {
        LottoResult.saveLottoResult(3, true);
        assertThat(lottoResult.getProfitRatio()).isEqualTo(5000/1000);
    }
}
