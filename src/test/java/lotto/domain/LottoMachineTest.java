package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    final LottoStrategy testStrategy = new TestStrategy();

    @Test
    @DisplayName("생성 테스트")
    void create() {
        final LottoMachine lottoMachine = new LottoMachine(10000, testStrategy);
        assertThat(lottoMachine)
                .isEqualTo(new LottoMachine(10000, testStrategy));
    }

    @Test
    @DisplayName("주어진 금액으로 몇 장의 로또인지 확인")
    void numberOfLottoTickets() {
        final LottoMachine lottoMachine = new LottoMachine(10001, testStrategy);

        assertThat(lottoMachine.countNumberOfLottoTickets())
                .isEqualTo(10);
    }
}
