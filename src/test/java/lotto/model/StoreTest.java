package lotto.model;

import lotto.exception.LottoCountException;
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
        LotteryTickets lotteryTickets = store.auto(14000);
        assertThat(lotteryTickets.getLottos()).hasSize(14);
    }

    @Test
    @DisplayName("수동으로 로또를 구입한다.")
    void manualBoughtLotto() {
        Store store = new Store(3);
        LotteryTickets lotteryTickets = store.manualLottos(
                List.of(
                        Set.of(1, 2, 3, 4, 5, 6),
                        Set.of(2, 3, 4, 5, 6, 7),
                        Set.of(3, 4, 5, 6, 7, 8))
        );


    }

    @Test
    @DisplayName("입력 받은 수동 로또의 갯수랑 실제로 생성된 로또의 갯수가 다르면 예외를 던진다.")
    void manualExceptionLottoSize() {
        assertThrows(LottoCountException.class, () -> {
            Store store = new Store(3);
            LotteryTickets lotteryTickets = store.manualLottos(
                    List.of(
                            Set.of(1, 2, 3, 4, 5, 6),
                            Set.of(2, 3, 4, 5, 6, 7),
                            Set.of(3, 4, 5, 6, 7, 8),
                            Set.of(3, 4, 5, 6, 7, 9)
                    )
            );
        });


    }

}