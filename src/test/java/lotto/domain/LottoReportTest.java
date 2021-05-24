package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class LottoReportTest {
    List<Lotto> lottos = Lists.newArrayList(
            번호_6개_일치,
            번호_6개_일치,
            번호_6개_일치,
            번호_6개_일치,
            번호_6개_일치,

            번호_5개_일치_보너스번호_일치,
            번호_5개_일치_보너스번호_일치,
            번호_5개_일치_보너스번호_일치,
            번호_5개_일치_보너스번호_일치,

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

    @Test
    void 로또통계를_3부터_6개까지_우승번호와_일치하는_경우의_수를_알려준다() {
        LottoReport report = new LottoReport(우승번호, new LottoList(lottos));
        assertAll(
                () -> assertThat(report.countWinnings(Rank.FIFTH)).isEqualTo(1),
                () -> assertThat(report.countWinnings(Rank.FOURTH)).isEqualTo(2),
                () -> assertThat(report.countWinnings(Rank.THIRD)).isEqualTo(3),
                () -> assertThat(report.countWinnings(Rank.SECOND)).isEqualTo(4),
                () -> assertThat(report.countWinnings(Rank.FIRST)).isEqualTo(5)
        );
    }

    @ParameterizedTest
    @MethodSource("provider_당첨통계는_수익률을_알려준다")
    void 당첨통계는_수익률을_알려준다(List<Lotto> lottos, double 수익률) {
        LottoReport report = new LottoReport(우승번호, new LottoList(lottos));
        assertThat(report.profitRate()).isEqualTo(수익률);
    }

    static Stream<Arguments> provider_당첨통계는_수익률을_알려준다() {
        return Stream.of(
                Arguments.of(Lists.newArrayList(
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_3개_일치
                ), 0.35),
                Arguments.of(Lists.newArrayList(
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_3개_일치
                ), 1),
                Arguments.of(Lists.newArrayList(
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_4개_일치
                ), 10),
                Arguments.of(Lists.newArrayList(
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_5개_일치
                ), 300),
                Arguments.of(Lists.newArrayList(
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_5개_일치_보너스번호_일치
                ), 6000),
                Arguments.of(Lists.newArrayList(
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_0개_일치,
                        번호_6개_일치
                ), 400000)
        );
    }
}
