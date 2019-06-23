package step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @Test
    @DisplayName("수익률 계산 [1등]")
    void benefit_percent_1st() {
        LottoStore lottoStore = new LottoStore();
        Money money = new Money(1000L);
        List<Lotto> lottos = lottoStore.buyLotto(money, new LottoGenerator() {
            @Override
            public Lotto generate() {
                return new Lotto(List.of(1, 2, 3, 4, 5, 6));
            }
        });

        LottoStatistics lottoStatistics = new LottoStatistics(money, lottos);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(2000000.0);
    }

    @Test
    @DisplayName("수익률 계산 [4등]")
    void benefit_percent_4th() {
        LottoStore lottoStore = new LottoStore();
        Money money = new Money(1000L);
        List<Lotto> lottos = lottoStore.buyLotto(money, new LottoGenerator() {
            @Override
            public Lotto generate() {
                return new Lotto(List.of(1, 2, 3, 10, 11, 12));
            }
        });

        LottoStatistics lottoStatistics = new LottoStatistics(money, lottos);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(5.0);
    }

    @Test
    @DisplayName("수익률 계산 [당첨 실패]")
    void benefit_percent_no_rank() {
        LottoStore lottoStore = new LottoStore();
        Money money = new Money(1000L);
        List<Lotto> lottos = lottoStore.buyLotto(money, new LottoGenerator() {
            @Override
            public Lotto generate() {
                return new Lotto(List.of(1, 2, 21, 10, 11, 12));
            }
        });

        LottoStatistics lottoStatistics = new LottoStatistics(money, lottos);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoStatistics.getBenefitPercent(winningLotto)).isEqualTo(0.0);
    }

    @Test
    @DisplayName("로또 번호 6개 모두 맞춘 경우 [당첨 등수 1등]")
    void check_my_rank() {
        LottoStore lottoStore = new LottoStore();
        Money money = new Money(1000L);
        List<Lotto> lottos = lottoStore.buyLotto(money, new LottoGenerator() {
            @Override
            public Lotto generate() {
                return new Lotto(List.of(1, 2, 3, 4, 5, 6));
            }
        });

        LottoStatistics lottoStatistics = new LottoStatistics(money, lottos);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoStatistics.checkMyRanks(winningLotto).get(0)).isEqualTo(LottoRank.SIX);
    }
}
