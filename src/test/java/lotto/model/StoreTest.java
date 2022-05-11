package lotto.model;

import lotto.exception.ManualLottoSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StoreTest {

    @Test
    @DisplayName("자동으로 로또를 생산한다.")
    void autoCreateLotto() {
        Store store = new Store(0);
        Lottos lotteryTickets = store.auto(14000);
        assertThat(lotteryTickets.getLottos()).hasSize(14);
    }

    @Test
    @DisplayName("수동으로 로또를 구입한다.")
    void manualBoughtLotto() {
        Store store = new Store(3);
        Lottos lotteryTickets = store.manualLottos(
                List.of(
                        Set.of(1, 2, 3, 4, 5, 6),
                        Set.of(2, 3, 4, 5, 6, 7),
                        Set.of(3, 4, 5, 6, 7, 8))
        );


    }

}