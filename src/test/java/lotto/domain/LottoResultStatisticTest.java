package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LottoResultStatisticTest {

    @Test
    @DisplayName("우승자 통계 테스트")
    void 우승자_통계_테스트() {
        Lottos lottos = Lottos.createLottos(1000, purchaseAmount -> new ArrayList<>());
        LottoResultStatistic lottoResultStatistic= lottos.calculateStatistic(2_000_005_000);

        Assertions.assertThat(lottoResultStatistic.getAllResult()
        ).isEqualTo("1, 0, 0, 0, 1");
    }

    @Test
    @DisplayName("특정 등수 몇번 당첨되었는지 잘 가져오는지 테스트")
    void 특정_등수_당첨_횟수_5등_2번() {
        Lottos lottos = Lottos.createLottos(1000, purchaseAmount -> new ArrayList<>());
        LottoResultStatistic lottoResultStatistic= lottos.calculateStatistic(10000);

        Assertions.assertThat(lottoResultStatistic.getResult(Prize.FIFTH)
        ).isEqualTo("2");
    }

}
