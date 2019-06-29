package step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @Test
    @DisplayName("수익률 계산 [1등]")
    void benefit_percent_1st() {
        Lottos lottos = new Lottos(List.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6))));
        LottoStatistics lottoStatistics = new LottoStatistics(new Money(1_000L), lottos);
        WinningLotto winningLotto = new WinningLotto(Lotto.create(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(2000000.0);
    }

    @Test
    @DisplayName("수익률 계산 [2등], 보너스 번호 맞춤")
    void benefit_percent_2th() {
        Lottos lottos = new Lottos(List.of(Lotto.create(List.of(1, 2, 3, 4, 5, 11))));
        LottoStatistics lottoStatistics = new LottoStatistics(new Money(1_000L), lottos);
        WinningLotto winningLotto = new WinningLotto(Lotto.create(List.of(1, 2, 3, 4, 5, 6)));
        winningLotto.addBonusNumber(new BonusNumber(11));

        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(3000.0);
    }

    @Test
    @DisplayName("수익률 계산 [3등], 보너스 번호 못맞춤")
    void benefit_percent_3th() {
        Lottos lottos = new Lottos(List.of(Lotto.create(List.of(1, 2, 3, 4, 5, 11))));
        LottoStatistics lottoStatistics = new LottoStatistics(new Money(1_000L), lottos);
        WinningLotto winningLotto = new WinningLotto(Lotto.create(List.of(1, 2, 3, 4, 5, 6)));
        winningLotto.addBonusNumber(new BonusNumber(12));

        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(1500.0);
    }

    @Test
    @DisplayName("수익률 계산 [당첨 실패]")
    void benefit_percent_no_rank() {
        Lottos lottos = new Lottos(List.of(Lotto.create(List.of(1, 2, 10, 11, 12, 13))));
        LottoStatistics lottoStatistics = new LottoStatistics(new Money(1_000L), lottos);
        WinningLotto winningLotto = new WinningLotto(Lotto.create(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(0.0);
    }

}
