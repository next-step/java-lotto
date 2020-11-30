package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoStatisticTest {

    @DisplayName("수익률 계산 테스트")
    @Test
    public void computeYieldTest() {
        List<DrawResult> drawResultList = new ArrayList<>();
        drawResultList.add(DrawResult.FIRST);
        drawResultList.add(DrawResult.FIRST);
        LottoStatistic lottoStatistic = new LottoStatistic(drawResultList, 2 * LottoTicket.PRICE);
        assertThat(lottoStatistic.getYield()).isEqualTo(2000000);
    }

    @DisplayName("등수별 갯수 테스트")
    @Test
    public void getRankLottoCountTest() {
        List<DrawResult> drawResultList = new ArrayList<>();
        drawResultList.add(DrawResult.FIRST);
        drawResultList.add(DrawResult.FIRST);
        drawResultList.add(DrawResult.SECOND);
        drawResultList.add(DrawResult.SECOND);
        drawResultList.add(DrawResult.SECOND);
        drawResultList.add(DrawResult.THIRD);
        drawResultList.add(DrawResult.THIRD);
        drawResultList.add(DrawResult.THIRD);
        drawResultList.add(DrawResult.THIRD);
        drawResultList.add(DrawResult.THIRD);
        drawResultList.add(DrawResult.THIRD);

        LottoStatistic lottoStatistic = new LottoStatistic(drawResultList, 2 * LottoTicket.PRICE);

        assertAll(
                () -> assertThat(lottoStatistic.getRankLottoCount(1)).isEqualTo(2),
                () -> assertThat(lottoStatistic.getRankLottoCount(2)).isEqualTo(3),
                () -> assertThat(lottoStatistic.getRankLottoCount(3)).isEqualTo(6)
        );
    }

}
