package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import lotto.domain.winning.WinningBall;
import lotto.domain.winning.WinningStat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

        assertThat(lottoMachine.makeLottos(amount, List.of()))
                .isInstanceOf(LottoBundle.class);
    }

    @Test
    @DisplayName("입력받은 금액으로 살 수 있는 로또보다 더 많은 수동 로또를 살 경우 예외 발생")
    void makeLottosAlot() {
        final Amount amount = new Amount(1000);

        assertThatThrownBy(() -> lottoMachine.makeLottos(amount, List.of("1,2,3,4,5,6", "10,11,12,13,14,15,16")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void conclusionWinningNumbers() {

        assertThat(this.lottoMachine.winningBall("1,2,3,4,5,6", 7))
                .isInstanceOf(WinningBall.class);
    }

    @Test
    @DisplayName("당첨 통계 확인")
    void winnerStat() {
        final LottoBundle lottoBundle = new LottoBundle(List.of(), 10);

        assertThat(this.lottoMachine.winningStat(lottoBundle, lottoMachine.winningBall("1,2,3,4,5,6", 10)))
                .isInstanceOf(WinningStat.class);
    }
}
