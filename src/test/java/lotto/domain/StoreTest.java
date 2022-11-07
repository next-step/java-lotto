package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.NO_MATCH;

class StoreTest {

    private Store store;

    @BeforeEach
    void setUp() {
        store = new Store(List.of(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), new LottoTicket(List.of(7, 8, 9, 10, 11, 12))));
    }

    @Test
    void 로또_구매() {
        Assertions.assertThat(store.getLottoTickets()).hasSize(2);
    }

    @Test
    void 발급된_로또티켓_사이즈_반환() {
        Assertions.assertThat(store.sizeOfLottoTickets()).isEqualTo(2);
    }

    @Test
    void 로또티켓_합쳐서_객체생성() {
        Store combinedStore = new Store(List.of(new LottoTicket(List.of(13, 14, 15, 16, 17, 18))));
        Assertions.assertThat(store.add(combinedStore).getLottoTickets()).hasSize(3);
    }

    @Test
    void 당첨등수_반환() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));
        Assertions.assertThat(store.match(winningLotto)).isEqualTo(List.of(FIRST, NO_MATCH));
    }

}
