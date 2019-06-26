package step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @Test
    @DisplayName("수익률 계산 [1등]")
    void benefit_percent_1st() {
        LottoStore lottoStore = LottoStore.getInstance();
        Money money = new Money(1_000L);
        Lotto lotto = Lotto.create();
        Lottos lottos = lottoStore.buyLotto(money, new Lottos(List.of(lotto)));

        LottoStatistics lottoStatistics = new LottoStatistics(money, lottos);
        WinningLotto winningLotto = new WinningLotto(lotto);
        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(2000000.0);
    }

    @Test
    @DisplayName("수익률 계산 [2등], 보너스 번호 맞춤")
    void benefit_percent_2th() {
        LottoStore lottoStore = LottoStore.getInstance();
        Money money = new Money(1_000L);
        Lottos lottos = lottoStore.buyLotto(money, new Lottos(List.of(new Lotto(List.of(LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(3), LottoNumber.create(4), LottoNumber.create(5), LottoNumber.create(13))))));

        LottoStatistics lottoStatistics = new LottoStatistics(money, lottos);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(3), LottoNumber.create(4), LottoNumber.create(5), LottoNumber.create(6))));
        winningLotto.addBonusNumber(new BonusNumber(13));
        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(3000.0);
    }

    @Test
    @DisplayName("수익률 계산 [3등], 보너스 번호 못맞춤")
    void benefit_percent_3th() {
        LottoStore lottoStore = LottoStore.getInstance();
        Money money = new Money(1_000L);
        Lottos lottos = lottoStore.buyLotto(money, new Lottos(List.of(new Lotto(List.of(LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(3), LottoNumber.create(4), LottoNumber.create(5), LottoNumber.create(13))))));

        LottoStatistics lottoStatistics = new LottoStatistics(money, lottos);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(3), LottoNumber.create(4), LottoNumber.create(5), LottoNumber.create(6))));
        winningLotto.addBonusNumber(new BonusNumber(11));
        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(1500.0);
    }

    @Test
    @DisplayName("수익률 계산 [당첨 실패]")
    void benefit_percent_no_rank() {
        LottoStore lottoStore = LottoStore.getInstance();
        Money money = new Money(1_000L);
        Lottos lottos = lottoStore.buyLotto(money, new Lottos(List.of(new Lotto(List.of(LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(13), LottoNumber.create(11), LottoNumber.create(12), LottoNumber.create(14))))));

        LottoStatistics lottoStatistics = new LottoStatistics(money, lottos);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(3), LottoNumber.create(4), LottoNumber.create(5), LottoNumber.create(6))));
        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(0.0);
    }

}
