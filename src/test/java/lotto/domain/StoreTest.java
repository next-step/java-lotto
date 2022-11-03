package lotto.domain;

import lotto.domain.lottogenerator.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Rank.*;

class StoreTest {

    private Store store;

    @BeforeEach
    void setUp() {
        LottoGenerator lottoGenerator = countOfTickets -> List.of(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), new LottoTicket(List.of(7, 8, 9, 10, 11, 12)));
        Money money = new Money(3000);
        store = new Store(lottoGenerator, money);
    }

    @Test
    void 로또_구매() {
        Assertions.assertThat(store.getLottoTickets()).hasSize(2);
    }

    @Test
    void 당첨등수_반환() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));
        Assertions.assertThat(store.match(winningLotto)).isEqualTo(List.of(FIRST, NO_MATCH));
    }

}
