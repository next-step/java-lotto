package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseAmountTest {

    @DisplayName("amount로 객체 생성")
    @Test
    void createByAmount() {
        // given & when
        PurchaseAmount purchaseAmount = new PurchaseAmount(BigDecimal.valueOf(14_000));

        // then
        assertThat(purchaseAmount.getCount()).isEqualTo(14);
    }

    @DisplayName("LottoTicket의 리스트로 객체 생성")
    @Test
    void createByLottoTickets() {
        // given
        List<LottoTicket> lottoTickets = createLottoTickets();

        // when
        PurchaseAmount purchaseAmount = new PurchaseAmount(lottoTickets);

        // then
        assertThat(purchaseAmount.getCount()).isEqualTo(3);
    }

    @DisplayName("총 상금으로 수익률 구하기")
    @Test
    void calculateEarningsRateByTotalPrize() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(BigDecimal.valueOf(14_000));

        // when
        double earningsRate = purchaseAmount.calculateEarningsRateByTotalPrize(BigDecimal.valueOf(5_000));

        // then
        assertThat(earningsRate).isEqualTo(0.35);
    }

    @DisplayName("티켓 개수를 받아 해당 금액만큼이 줄어든 새로운 객체를 리턴")
    @Test
    void minusAmountBy() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(createLottoTickets());

        // when
        PurchaseAmount deducted = purchaseAmount.minusAmountBy(2);

        // then
        assertThat(deducted.getTotalAmount()).isEqualTo(BigDecimal.valueOf(1_000L));
    }

    private List<LottoTicket> createLottoTickets() {
        LottoTicket lottoTicket0 = new LottoTicket(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6)
                )
        );
        LottoTicket lottoTicket1 = new LottoTicket(
                Arrays.asList(
                        LottoNumber.of(7),
                        LottoNumber.of(8),
                        LottoNumber.of(9),
                        LottoNumber.of(10),
                        LottoNumber.of(11),
                        LottoNumber.of(2)
                )
        );
        LottoTicket lottoTicket2 = new LottoTicket(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(3),
                        LottoNumber.of(5),
                        LottoNumber.of(7),
                        LottoNumber.of(9),
                        LottoNumber.of(11)
                )
        );
        return Arrays.asList(
                lottoTicket0, lottoTicket1, lottoTicket2
        );
    }
}