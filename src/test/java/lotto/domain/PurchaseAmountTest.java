package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseAmountTest {

    @DisplayName("amount로 객체 생성")
    @Test
    void createByAmount() {
        // given & when
        int amount = 14000;
        int count = 14;
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        // then
        assertThat(purchaseAmount.getAmount()).isEqualTo(amount);
        assertThat(purchaseAmount.getCount()).isEqualTo(count);
    }

    @DisplayName("LottoTicket의 리스트로 객체 생성")
    @Test
    void createByLottoTickets() {
        // given
        List<LottoTicket> lottoTickets = createLottoTickets();

        // when
        PurchaseAmount purchaseAmount = new PurchaseAmount(lottoTickets);

        // then
        assertThat(purchaseAmount.getAmount()).isEqualTo(3000);
        assertThat(purchaseAmount.getCount()).isEqualTo(3);
    }

    private List<LottoTicket> createLottoTickets() {
        LottoTicket lottoTicket0 = new LottoTicket(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );
        LottoTicket lottoTicket1 = new LottoTicket(
                Arrays.asList(
                        new LottoNumber(7),
                        new LottoNumber(8),
                        new LottoNumber(9),
                        new LottoNumber(10),
                        new LottoNumber(11),
                        new LottoNumber(2)
                )
        );
        LottoTicket lottoTicket2 = new LottoTicket(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(3),
                        new LottoNumber(5),
                        new LottoNumber(7),
                        new LottoNumber(9),
                        new LottoNumber(11)
                )
        );
        return Arrays.asList(
                lottoTicket0, lottoTicket1, lottoTicket2
        );
    }
}