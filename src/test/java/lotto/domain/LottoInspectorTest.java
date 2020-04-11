package lotto.domain;

import lotto.domain.*;
import lotto.domain.InsightResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInspectorTest {

    private LottoInspector lottoInspector;
    private List<Lotto> testLottos = new ArrayList<>();

    @BeforeEach
    void setting() {
        this.lottoInspector = new LottoInspector();

        Lotto lotto1 = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.of(Arrays.asList(1, 2, 3, 41, 42, 43));
        testLottos.add(lotto1);
        testLottos.add(lotto2);
    }

    @Test
    @DisplayName("수익률 가져오기 테스트")
    void getYieldTest() {
        assertThat(
                this.lottoInspector.getYield(new Money(1000), 5000)
        ).isEqualByComparingTo(new BigDecimal(5));
    }

    @Test
    @DisplayName("결과 가져오기 테스트")
    void getResultTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        Map<RankEnum, Integer> targetInsightReuslt = new HashMap<>();
        targetInsightReuslt.put(RankEnum.FIRST, 1);
        targetInsightReuslt.put(RankEnum.SECOND, 0);
        targetInsightReuslt.put(RankEnum.THIRD, 0);
        targetInsightReuslt.put(RankEnum.FOURTH, 0);
        targetInsightReuslt.put(RankEnum.FIFTH, 1);
        targetInsightReuslt.put(RankEnum.NO_RANK, 0);

        assertThat(
                lottoInspector.getResult(winningLotto, new Lottos(testLottos))
        ).isEqualTo(new InsightResults(targetInsightReuslt));
    }
}
