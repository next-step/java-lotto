package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {



    @Test
    void matchWinResultTest() {
        List<Lotto> lottoList = Arrays.asList(
            Lotto.from(Arrays.asList("1","2","3","4","5","6")),
            Lotto.from(Arrays.asList("11","12","3","4","5","6")),
            Lotto.from(Arrays.asList("11","12","13","14","15","16")),
            Lotto.from(Arrays.asList("11","12","13","14","15","6"))
        ) ;
        Lottos lottos = new Lottos(lottoList);

        LottoResults lottoResults = lottos.matchWinLotto(Lotto.from(Arrays.asList("1","2","3","4","5","6")));

        assertThat(lottoResults.findRankResult(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResults.findRankResult(LottoRank.SECOND)).isZero();
        assertThat(lottoResults.findRankResult(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoResults.findRankResult(LottoRank.FOURTH)).isZero();
        assertThat(lottoResults.findRankResult(LottoRank.NONE)).isEqualTo(2);
    }
}
