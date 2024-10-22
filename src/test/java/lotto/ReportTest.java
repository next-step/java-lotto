package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportTest {

    @Test
    @DisplayName("발급된 로또를 1장씩 화면에 출력한다.")
    void testPrintLotto() {
        WinningRules winningRules = new WinningRules(List.of(
                new WinningRule(3, 5000),
                new WinningRule(4, 50000),
                new WinningRule(5, 1500000),
                new WinningRule(6, 2000000000)
        ));
        Report report = new Report(winningRules);

        List<Lotto> lottos = List.of(new Lotto(1L), new Lotto(2L));

        assertThat(report.reportTotalOrders(new Orders(lottos)))
                .isEqualTo("2개를 구매했습니다.\n[5, 16, 29, 34, 38, 45]\n[14, 16, 21, 25, 38, 43]\n");
    }

    @Test
    @DisplayName("당첨 통계를 출력한다.")
    void testReportWinners() {
        WinningRules winningRules = new WinningRules(List.of(
                new WinningRule(3, 5000),
                new WinningRule(4, 50000),
                new WinningRule(5, 1500000),
                new WinningRule(6, 2000000000)
        ));
        Report report = new Report(winningRules);

        Statistics statistics = new Statistics();
        statistics.put(3, 10);
        statistics.put(4, 1);
        statistics.put(5, 0);
        statistics.put(6, 0);

        assertThat(report.reportWinners(statistics)).isEqualTo("당첨 통계\n---------\n3개 일치 (5000원)- 10개\n4개 일치 (50000원)- 1개\n5개 일치 (1500000원)- 0개\n6개 일치 (2000000000원)- 0개\n");
    }

    @Test
    @DisplayName("총 수익률을 출력한다.")
    void testReportRateOfReturn() {
        WinningRules winningRules = new WinningRules(List.of(
                new WinningRule(3, 5000),
                new WinningRule(4, 50000),
                new WinningRule(5, 1500000),
                new WinningRule(6, 2000000000)
        ));
        Report report = new Report(winningRules);

        Statistics statistics = new Statistics();
        statistics.put(3, 1);
        statistics.put(4, 0);
        statistics.put(5, 0);
        statistics.put(6, 0);

        assertThat(report.reportRateOfReturn(14000, statistics)).isEqualTo("총 수익률은 0.35입니다.");

    }
}
