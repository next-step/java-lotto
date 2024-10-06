package lotto.domain.prize;

import lotto.constant.Prize;
import lotto.domain.sales.LottoBundle;
import lotto.domain.number.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningReportTest {

    Lotto winningLotto = Lotto.of("1,2,3,4,5,6");

    @Test
    void 당첨_등수() {
        LottoBundle lottoBundle = LottoBundle.of(List.of(
                Lotto.of("1,2,3,4,5,6"),
                Lotto.of("1,2,3,4,5,7"),
                Lotto.of("1,2,3,4,7,8"),
                Lotto.of("1,2,3,7,8,9"),
                Lotto.of("1,22,23,24,25,26"),
                Lotto.of("21,22,23,24,25,26")));

        WinningReport report = WinningReport.of(lottoBundle.count() * 1000, lottoBundle, winningLotto);
        report.analyze();

        assertThat(report.first()).isEqualTo(1);
        assertThat(report.second()).isEqualTo(1);
        assertThat(report.third()).isEqualTo(1);
        assertThat(report.fourth()).isEqualTo(1);
    }

    @Test
    void 당첨_액수() {
        LottoBundle lottoBundle = LottoBundle.of(List.of(
                Lotto.of("1,22,23,24,25,26"),
                Lotto.of("1,22,23,24,25,7"),
                Lotto.of("1,2,3,4,7,8"),
                Lotto.of("1,2,3,7,8,9"),
                Lotto.of("1,22,23,24,25,26"),
                Lotto.of("21,22,23,24,25,26")));

        int salesAmount = lottoBundle.count() * 1000;
        WinningReport report = WinningReport.of(salesAmount, lottoBundle, winningLotto);
        report.analyze();

        assertThat(report.winningRate())
                .isEqualTo((double)(Prize.THIRD.getPrize() + Prize.FOURTH.getPrize())/ salesAmount);
    }
}
