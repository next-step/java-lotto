package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {

    @Test
    public void 로또결과_합계(){
        LottoResult lottoResult = new LottoResult(Rank.valueOf(3, false), 5);
        assertThat(lottoResult.sumResult()).isEqualTo(25000);
    }

    @Test
    public void 로또결과_5등_보너스_미포함(){
        LottoResult lottoResult = new LottoResult(Rank.valueOf(5, false), 1);
        assertThat(lottoResult.sumResult()).isEqualTo(1_500_000);
    }

    @Test
    public void 로또결과_5등_보너스_포함(){
        LottoResult lottoResult = new LottoResult(Rank.valueOf(5, true), 1);
        assertThat(lottoResult.sumResult()).isEqualTo(30_000_000);
    }
}
