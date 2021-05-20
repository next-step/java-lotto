package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoMachineTest {

    @Test
    public void 로또게임발행() {
        LottoMachine machine = new LottoMachine();
        LottoGames games = machine.createLottoGames(14000);

        assertThat(games.size()).isEqualTo(14);

    }
}
