package lotto.domain;

import lotto.generic.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @DisplayName("로또 티켓 구매")
    @Test
    void buy() {
        LottoTickets lottoTickets = LottoGame.buy(Money.wons(14500));
        assertThat(lottoTickets.getLottoTickets()).hasSize(14);
    }
}
