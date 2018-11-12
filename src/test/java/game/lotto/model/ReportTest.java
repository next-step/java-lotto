package game.lotto.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportTest {

    @Test
    public void 수익여부_손해() {
        Report report = new Report(null, null);

        String message = report.getEarningMessage(new BigDecimal(0.99));

        assertThat(message).isEqualTo("손해");
    }

    @Test
    public void 수익여부_본전() {
        Report report = new Report(null, null);

        String message = report.getEarningMessage(new BigDecimal(1));

        assertThat(message).isEqualTo("본전");
    }

    @Test
    public void 수익여부_이익() {
        Report report = new Report(null, null);

        String message = report.getEarningMessage(new BigDecimal(1.01));

        assertThat(message).isEqualTo("이익");
    }
    
    @Test
    public void 결과생성확인() {
        
        final String exepected = "당첨 통계" + Report.LINE_SEPARATOR +
                                "---------" + Report.LINE_SEPARATOR +
                                "3개 일치 (5000원) - 0개" + Report.LINE_SEPARATOR +
                                "4개 일치 (50000원) - 0개" + Report.LINE_SEPARATOR +
                                "5개 일치 (1500000원) - 0개" + Report.LINE_SEPARATOR +
                                "5개 일치, 보너스 볼 일치(30000000원) - 0개" + Report.LINE_SEPARATOR +
                                "6개 일치 (2000000000원) - 0개" + Report.LINE_SEPARATOR +
                                "총 수익률은 0.00 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

        Report report = new Report(new MatchResult(), new Money(1000));

        assertThat(report.makeStringReport()).isEqualTo(exepected);
    }
    
}