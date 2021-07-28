package lotto.auto.model;

import lotto.auto.context.ConstantContext;
import lotto.auto.strategy.AutoLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class LottoGameMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = LottoMachine.from(AutoLotto.init());
    }

    @Test
    @DisplayName("14,000원을 투입하면 14게임을 진행한다. 한 게임에 번호는 6개씩 들어있다")
    void ticketing() {
        LottoMachine lottoMachine = LottoMachine.from(AutoLotto.init());
        List<LottoGame> lottoGames = lottoMachine.ticketing(14000);
        Assertions.assertThat(lottoGames.size()).isEqualTo(14);
        Assertions.assertThat(lottoGames).filteredOn(ticket -> ticket.size() == 6);
    }

    @Test
    @DisplayName("정상 입력시 정상 통계를 반환한다")
    void producingStatistic() {
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        List<LottoGame> ticketing = lottoMachine.ticketing(10000);

        Map<String, Object> statistic = lottoMachine.producingStatistic(winningNumbers, ticketing);
        Assertions.assertThat(statistic).isNotNull();
        Assertions.assertThat(statistic.size()).isEqualTo(2);
        Assertions.assertThat(statistic.get(ConstantContext.MATCH_TABLE_KEY)).isNotNull().isInstanceOf(int[].class);
        Assertions.assertThat(statistic.get(ConstantContext.EARNINGS_RATE_KEY)).isNotNull().isInstanceOf(Double.class);
    }

    @Test
    @DisplayName("비정상 입력시 예외를 던진다")
    void producingStatisticException() {
        int[] winningNumbers = {1, 2, 3, 4, 5};
        List<LottoGame> ticketing = lottoMachine.ticketing(10000);
        Assertions.assertThatThrownBy(() -> lottoMachine.producingStatistic(winningNumbers, ticketing))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("there must be 6 numbers.");
    }
}
