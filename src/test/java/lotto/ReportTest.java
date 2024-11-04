package lotto;

import lotto.domain.*;
import lotto.view.Report;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportTest {

    @Test
    @DisplayName("발급된 로또를 1장씩 화면에 출력한다.")
    void testPrintLotto() {
        Report report = new Report();

        List<Lotto> lottos = List.of(new Lotto(1L), new Lotto(2L));

        assertThat(report.reportTotalOrders(new Orders(lottos)))
                .isEqualTo("2개를 구매했습니다.\n[5, 16, 29, 34, 38, 45]\n[14, 16, 21, 25, 38, 43]\n");
    }

    @Test
    @DisplayName("당첨 통계를 출력한다.")
    void testReportWinners() {
        Report report = new Report();

        Statistics statistics = new Statistics();
        statistics.put(WinningRule.THREE, 10);
        statistics.put(WinningRule.FOUR, 1);
        statistics.put(WinningRule.FIVE, 0);
        statistics.put(WinningRule.FIVE_BONUS, 1);
        statistics.put(WinningRule.SIX, 0);

        assertThat(report.reportWinners(statistics, WinningRules.getDefaultWinningRules())).isEqualTo("당첨 통계\n---------\n3개 일치 (5000원)- 10개\n4개 일치 (50000원)- 1개\n5개 일치 (1500000원)- 0개\n5개 일치, 보너스 볼 일치 (30000000원)- 1개\n6개 일치 (2000000000원)- 0개\n");
    }
}
