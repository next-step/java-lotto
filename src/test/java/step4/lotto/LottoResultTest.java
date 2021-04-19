package step4.lotto;

import org.junit.jupiter.api.Test;
import step4.lotto.domain.Count;
import step4.lotto.domain.LottoResult;
import step4.lotto.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void init() {
        assertThat(new LottoResult()).isEqualTo(new LottoResult());
    }

    @Test
    void 로또_1등_2회() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusRankCount(Rank.FIRST);
        lottoResult.plusRankCount(Rank.FIRST);

        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(new Count(2));
    }

    @Test
    void 로또_1등_3회일때_나머지_등수_갯수() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusRankCount(Rank.FIRST);
        lottoResult.plusRankCount(Rank.FIRST);
        lottoResult.plusRankCount(Rank.FIRST);

        Count zero = new Count();
        for(Rank rank : Rank.values()){
            if(rank != Rank.FIRST){
                assertThat(lottoResult.getRankCount(rank)).isEqualTo(zero);
            }
        }
    }
}
