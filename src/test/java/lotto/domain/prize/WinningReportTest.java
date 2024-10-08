package lotto.domain.prize;

import lotto.constant.LottoPrize;
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

        assertThat(report.winAmount(LottoPrize.FOURTH.getMatch())).isEqualTo(1);
        assertThat(report.winAmount(LottoPrize.THIRD.getMatch())).isEqualTo(1);
        assertThat(report.winAmount(LottoPrize.SECOND.getMatch())).isEqualTo(1);
        assertThat(report.winAmount(LottoPrize.FIRST.getMatch())).isEqualTo(1);
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

        assertThat(report.winningRate())
                .isEqualTo((double)(LottoPrize.THIRD.getPrize() + LottoPrize.FOURTH.getPrize())/ salesAmount);
    }
}
