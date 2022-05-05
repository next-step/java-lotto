package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoVendingMachine.PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoVendingMachineTest {
    private static final long TEN_THOUSAND = 10000;

    @Test
    void LottoVendingMachine은_lottoNumbers없이_생성_할_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoVendingMachine(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void vend는_PRICE당_하나의_티켓을_반환한다() {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        LottoTickets lottoTickets = lottoVendingMachine.vend(new Amount(TEN_THOUSAND));

        assertThat(lottoTickets.size()).isEqualTo(TEN_THOUSAND / PRICE);
    }
}
