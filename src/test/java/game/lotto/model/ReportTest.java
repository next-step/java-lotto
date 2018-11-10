package game.lotto.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportTest {

    @Test
    public void 수익률_계산() {
        final Money money = new Money(50000);
        final MatchResult matchResult = new MatchResult();
        matchResult.incrementMatch(3);
        matchResult.incrementMatch(3);
        final BigDecimal expected = new BigDecimal(matchResult.getTotalPrize())
                                    .divide(
                                            new BigDecimal(money.getValue()),
                                            Report.SCALE,
                                            RoundingMode.HALF_UP
                                    );
        final Report report = new Report(matchResult, money);

        BigDecimal earningRate = report.computeEarningRate();

        assertThat(earningRate).isEqualTo(expected);
    }

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