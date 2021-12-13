package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {

    @Test
    void 로또결과_합계(){
        LottoResult lottoResult = new LottoResult(Rank.valueOf(3, false), 5);
        assertThat(lottoResult.sumResult()).isEqualTo(25000);
    }

    @Test
    void 로또결과_5등_보너스_미포함(){
        LottoResult lottoResult = new LottoResult(Rank.valueOf(5, false), 1);
        assertThat(lottoResult.sumResult()).isEqualTo(1_500_000);
    }

    @Test
    void 로또결과_5등_보너스_포함(){
        LottoResult lottoResult = new LottoResult(Rank.valueOf(5, true), 1);
        assertThat(lottoResult.sumResult()).isEqualTo(30_000_000);
    }

    @Test
    void 랭크() {
        Rank rank = Rank.FIFTH;
        LottoResult lottoResult = new LottoResult(rank, 1);
        assertThat(lottoResult.getRank()).isEqualTo(rank);
    }

    @Test
    void 맞힌_횟수() {
        LottoResult lottoResult = new LottoResult(Rank.FIFTH, 1);
        assertThat(lottoResult.getNumberOfTimes()).isEqualTo(1);
    }
}
