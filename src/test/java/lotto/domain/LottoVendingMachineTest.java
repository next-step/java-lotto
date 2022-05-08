package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoNumbers.generateLottoNumbers;
import static lotto.domain.LottoVendingMachine.PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoVendingMachineTest {
    private static final long TEN_THOUSAND = 10000;

    @Test
    void LottoVendingMachine은_lottoNumbers없이_생성_할_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoVendingMachine(null, new Amount());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoVendingMachine은_balance없이_생성_할_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoVendingMachine(new LottoNumbers(List.of(new LottoNumber(1))), null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void vend는_잔액의_PRICE당_하나의_랜덤_티켓을_반환한다() {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        lottoVendingMachine.insert(new Amount(TEN_THOUSAND));
        LottoTickets lottoTickets = lottoVendingMachine.vend();

        assertThat(lottoTickets.size()).isEqualTo(TEN_THOUSAND / PRICE);
    }

    @Test
    void vend는_lottoNumbers당_하나의_티켓을_반환한다() {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        lottoVendingMachine.insert(new Amount(TEN_THOUSAND));
        LottoTickets lottoTickets = lottoVendingMachine.vend(List.of(generateLottoNumbers(1, 6), generateLottoNumbers(1, 6)));

        assertThat(lottoTickets.size()).isEqualTo(2);
    }

    @Test
    void vend는_잔액보다_많이_요청한_경우_예외를_발생_시킨다() {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        lottoVendingMachine.insert(new Amount());

        assertThatThrownBy(() -> {
            lottoVendingMachine.vend(List.of(generateLottoNumbers(1, 6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void insert는_잔액을_증가시킨다() {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        Amount tenThousand = new Amount(TEN_THOUSAND);
        lottoVendingMachine.insert(tenThousand);

        assertThat(lottoVendingMachine.getBalance().getAmount())
                .isEqualTo(tenThousand.getAmount());
    }
}
