package lotto.entity;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoMachineTest {
    @Test
    void 금액_입력_시_반환_되는_로또_리스트() {
        LottoMachine machine = new LottoMachine();

        List<Lotto> lottos = machine.insert(14000);

        assertThat(lottos).hasSize(14);

    }

    @Test
    void 로또_리스트_와_당첨_번호_입력_시_당첨_복권_리스트_사이즈_검증() {
        LottoMachine machine = new LottoMachine();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 20, 21, 22)),
                new Lotto(Arrays.asList(1, 2, 3, 30, 31, 32)),
                new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42))
        );

        List<Integer> winnersNumber = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<WinnerLotto> winners = machine.winnerLottos(lottos, winnersNumber);

        assertAll(
                () -> assertThat(winners).hasSize(1)
        );
    }

}
