package lotto;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.LottoFixture.*;
import static org.assertj.core.api.Assertions.assertThat;


public class LottoReportTest {
    @Test
    void 로또통계를_3부터_6개까지_우승번호와_일치하는_경우의_수를_알려준다() {
        List<Lotto> lottos = Lists.newArrayList(
                번호_6개_일치,
                번호_6개_일치,
                번호_6개_일치,
                번호_6개_일치,
                번호_5개_일치,
                번호_5개_일치,
                번호_5개_일치,
                번호_4개_일치,
                번호_4개_일치,
                번호_3개_일치,
                번호_2개_일치,
                번호_1개_일치,
                번호_0개_일치
        );
        LottoReport report = new LottoReport(우승번호, lottos);
        assertThat(report.threeMatched()).isEqualTo(1);
        assertThat(report.fourMatched()).isEqualTo(2);
        assertThat(report.fiveMatched()).isEqualTo(3);
        assertThat(report.sixMatched()).isEqualTo(4);
    }
}
