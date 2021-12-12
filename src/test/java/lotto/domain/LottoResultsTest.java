package lotto.domain;

import lotto.strategy.CreationAutoLottoNumber;
import lotto.strategy.CreationLottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultsTest {
    private LottoResults lottoResults;

    @BeforeEach
    void setUp(){
        lottoResults = new LottoResults(Arrays.asList(
            new LottoResult(Rank.FIFTH, 1),
            new LottoResult(Rank.FOURTH, 1),
            new LottoResult(Rank.THIRD, 1),
            new LottoResult(Rank.SECOND, 0),
            new LottoResult(Rank.FIRST, 0)
        ));
    }

    @Test
    public void 로또_결과_비교() {
        Lottos lottos = new Lottos(Arrays.asList(
            new Lotto("1,2,3,14,15,16"),
            new Lotto("1,2,3,4,15,16"),
            new Lotto("1,2,3,4,5,16")
        ));
        assertThat(LottoResults.of(lottos.getLottos(), new PrizeLotto("1,2,3,4,5,6", "7"))).isEqualTo(lottoResults);
    }

    @Test
    public void 상금_총합() {
        assertThat(lottoResults.totalEarnMoney()).isEqualTo(1555000.0F);
    }
}
