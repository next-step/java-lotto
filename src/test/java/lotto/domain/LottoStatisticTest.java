package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class LottoStatisticTest {

    @Test
    void 통계정보() {

        List<Lotto> lottos = List.of(Lotto.of(List.of(1, 0, 0, 0, 0, 0)),
                Lotto.of(List.of(1, 2, 0, 0, 0, 0)),
                Lotto.of(List.of(1, 2, 3, 0, 0, 0)),
                Lotto.of(List.of(1, 2, 3, 4, 0, 0)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 0)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)));

        LottoStatistic lottoStatistic = new LottoStatistic(Lotto.of(List.of(1,2,3,4,5,6)), new Buy(1000, 6000), lottos);

        int sum = LottoResult.FIRST.getMoney() + LottoResult.SECOND.getMoney() + LottoResult.THIRD.getMoney() + LottoResult.FORTH.getMoney();

        assertThat(lottoStatistic.getWinMoneyTotal()).isEqualTo(sum);
        assertThat(lottoStatistic.getLottoResultCounter().get(LottoResult.FIRST)).isEqualTo(1);
        assertThat(lottoStatistic.getLottoResultCounter().get(LottoResult.NONE)).isEqualTo(2);
        assertThat(lottoStatistic.getRevenue()).isEqualTo(Double.valueOf(sum) / Double.valueOf(6000));
        assertThat(lottoStatistic.isLost()).isFalse();
    }
}