package lotto;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsReportTest {

    @DisplayName("지난주 로또와 3개가 매칭된 로또 티켓이 2개 만들어진다.")
    @Test
    void a() {
        Prize third = Prize.THIRD;
        StatisticsReport statisticsReport = new StatisticsReport(Map.of(third, 2));
        Assertions.assertThat(statisticsReport.countByPrize(third)).isEqualTo(2);
    }

}
