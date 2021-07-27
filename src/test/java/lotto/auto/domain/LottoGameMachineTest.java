package lotto.auto.domain;

import lotto.auto.model.LottoGame;
import lotto.auto.strategy.AutoLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoGameMachineTest {
    @Test
    @DisplayName("로또기계가 정상적으로 생성되는지 테스트한다")
    void from() {
        LottoMachine lottoMachine = LottoMachine.from(AutoLotto.init());
        Assertions.assertThat(lottoMachine).isInstanceOf(LottoMachine.class);
    }

    @Test
    @DisplayName("14,000원을 투입하면 14게임을 진행한다. 한 게임에 번호는 6개씩 들어있다")
    void ticketing() {
        LottoMachine lottoMachine = LottoMachine.from(AutoLotto.init());
        List<LottoGame> lottoGames = lottoMachine.ticketing(14000);
        Assertions.assertThat(lottoGames.size()).isEqualTo(14);
        Assertions.assertThat(lottoGames).filteredOn(ticket -> ticket.size() == 6);
    }
}
