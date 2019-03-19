package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoTicketMachineTest {

    @Test
    public void test_purchase() {
        final int purchaseWon = 15000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(purchaseWon);

        assertThat(lottoTicket.getLottos().size()).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)
    public void test_purchase_음수() {
        final int purchaseWon = -10000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(purchaseWon);
    }

    @Test
    public void test_purchase_원단위_절삭() {
        final int purchaseWon = 14500;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(purchaseWon);

        assertThat(lottoTicket.getLottos().size()).isEqualTo(14);
    }
}