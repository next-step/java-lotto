package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import lotto.domain.winning.WinningStat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    final LottoStrategy testStrategy = new TestStrategy();
    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("주어진 금액으로 몇 장의 로또인지 확인")
    void calculateUnitCount() {
        final LottoMachine lottoMachine = new LottoMachine();
        final Amount amount = new Amount(10001);

        assertThat(lottoMachine.calculateUnitCount(amount))
                .isEqualTo(10);
    }

    @Test
    @DisplayName("돈을 받으면 로또뭉치를 반환")
    void makeLottos() {
        final Amount amount = new Amount(10000);

        assertThat(lottoMachine.makeLottos(amount, testStrategy))
                .isInstanceOf(Lottos.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void conclusionWinningNumbers() {
        final Lotto winningLotto = new Lotto(testStrategy);

        assertThat(this.lottoMachine.winningLotto("1,2,3,4,5,6"))
                .isEqualTo(winningLotto);
    }

    @Test
    @DisplayName("당첨 통계 확인")
    void winnerStat() {
        final Lottos lottos = new Lottos(10, testStrategy);
        final Amount amount = new Amount(10000);

        final Lotto winningLotto = this.lottoMachine.winningLotto("1,2,3,4,5,6");

        assertThat(this.lottoMachine.winningStat(lottos, winningLotto))
                .isInstanceOf(WinningStat.class);
    }
}
