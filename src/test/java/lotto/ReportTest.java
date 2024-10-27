package lotto;

import lotto.domain.Lotto;
import lotto.domain.Orders;
import lotto.domain.Statistics;
import lotto.domain.WinningRules;
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
        statistics.put(3, 10);
        statistics.put(4, 1);
        statistics.put(5, 0);
        statistics.put(6, 0);

        assertThat(report.reportWinners(statistics, WinningRules.getDefaultWinningRules())).isEqualTo("당첨 통계\n---------\n3개 일치 (5000원)- 10개\n4개 일치 (50000원)- 1개\n5개 일치 (1500000원)- 0개\n6개 일치 (2000000000원)- 0개\n");
    }
}
