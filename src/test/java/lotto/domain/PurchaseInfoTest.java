package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseInfoTest {

    private PurchasePrice purchasePrice;
    private List<LottoTicket> manualTickets;
    private PurchaseInfo purchaseInfo;

    @BeforeEach
    void setUp() {
        this.purchasePrice = PurchasePrice.newInstance(5000);
        this.manualTickets = Arrays.asList(
                LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 6"),
                LottoTicketFactory.createManualLottoTicket("7, 8, 9, 10, 11, 12")
        );

        this.purchaseInfo = PurchaseInfo.newInstance(this.purchasePrice, this.manualTickets);
    }

    @DisplayName("구입 금액이 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreatePurchaseInfoIfPurchasePriceIsNull() {
        assertThatThrownBy(() -> PurchaseInfo.newInstance(null, this.manualTickets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또 번호가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreatePurchaseInfoIfManualTicketsIsNull() {
        assertThatThrownBy(() -> PurchaseInfo.newInstance(this.purchasePrice, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 정보를 생성할 수 있다.")
    @Test
    void canCreatePurchaseInfo() {
        assertThat(this.purchaseInfo).isInstanceOf(PurchaseInfo.class);
    }

    @DisplayName("수동 구매 로또 수를 얻을 수 있다.")
    @Test
    void canGetManualTicketCount() {
        assertThat(this.purchaseInfo.getManualTicketCount()).isEqualTo(2);
    }

    @DisplayName("자동 로또 수를 얻을 수 있다.")
    @Test
    void canGetAutoTicketCount() {
        assertThat(this.purchaseInfo.getAutoTicketCount()).isEqualTo(3);
    }

    @DisplayName("수동 로또를 얻을 수 있다.")
    @Test
    void canGetManualTickets() {
        assertThat(this.purchaseInfo.getManualTickets()).isEqualTo(this.manualTickets);
    }
}
