package lotto.dto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    private LottoGenerator lottoGenerator;
    private Lottos lottos;

    @BeforeEach
    void setup() {
        lottoGenerator = new TesterLottoGenerator();

        Lotto lotto = build(LottoRank.FOURTH);
        List<Lotto> lottoList = Collections.singletonList(lotto);

        lottos = new Lottos(lottoList);
        lottos.setStatistics();
    }

    @DisplayName("LottoStatistics 생성 테스트")
    @Test
    void of() {
        LottoStatistics statistics = new LottoStatistics(lottos);

        assertThat(statistics.getStatisticsValue().get(0).getLottoCount()).isEqualTo(1);
        assertThat(statistics.getStatisticsValue().get(1).getLottoCount()).isZero();
        assertThat(statistics.getStatisticsValue().get(2).getLottoCount()).isZero();
        assertThat(statistics.getStatisticsValue().get(3).getLottoCount()).isZero();

        assertThat(statistics.getProfitRate()).isEqualByComparingTo("5.00");
    }

    private Lotto build(LottoRank lottoRank) {
        Lotto lotto = Lotto.of(lottoGenerator);
        lotto.scratchLotto(lottoRank);
        return lotto;
    }
}
