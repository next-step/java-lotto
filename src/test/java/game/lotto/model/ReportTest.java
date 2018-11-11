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

}