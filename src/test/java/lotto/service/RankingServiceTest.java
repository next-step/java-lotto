package lotto.service;

import lotto.common.LottoResult;
import lotto.common.LottoResults;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.RankingCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingServiceTest {

    @Test
    public void RankingService에서_몇개를_몇번맞췄는지_확인할_수_있다(){
        //given
        RankingService service = new RankingService();
        //when
        LottoResults lottoResults = service.calculateMatchHits(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), initializeLottos(), new RankingCalculator());
        //then
        assertThat(lottoResults).isEqualTo(getExpected());
    }

    private LottoResults getExpected() {
        LottoResults expected = new LottoResults();
        expected.addAll(new LottoResult(3, 3), new LottoResult(4, 0), new LottoResult(5, 1), new LottoResult(6, 0));
        return expected;
    }

    private Lottos initializeLottos() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 8, 11, 29)));
        lottos.add(new Lotto(Arrays.asList(2, 3, 6, 9, 10, 22)));
        lottos.add(new Lotto(Arrays.asList(2, 3, 5, 9, 17, 22)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 9, 10, 23, 44)));

        return lottos;
    }
}
