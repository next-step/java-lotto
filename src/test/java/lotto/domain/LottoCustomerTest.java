package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCustomerTest {

    private static LottoTicket lottoTicket1;
    private static LottoTicket lottoTicket2;
    private static LottoCustomer customer;

    @BeforeEach
    void setup() {
        lottoTicket1 = new LottoTicket(Money.wons(100), LottoNumbers.of(1, 2, 3, 4, 5, 6));
        lottoTicket2 = new LottoTicket(Money.wons(200), LottoNumbers.of(45, 44, 43, 42, 41, 40));
        customer = new LottoCustomer(Money.wons(1_000));
    }

    @DisplayName("가진 금액이, 로또 구매 가격보다 적다면, 로또를 구입 할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {0, 50, 99})
    void purchase_nothing(final int amount) {
        final Money initialAmount = Money.wons(amount);
        final LottoCustomer customer = new LottoCustomer(initialAmount);

        // Validate PreCondition
        assertThat(customer.canPurchase(lottoTicket1)).isFalse();

        assertThat(customer.purchase(lottoTicket1)).isEqualTo(Money.ZERO);

        // Validate PostCondition
        assertThat(customer.getPurchasedCount()).isZero();
        assertThat(customer.getPurchasedLottoTickets()).isEmpty();
    }

    @DisplayName("가진 금액이, 로또를 딱 한 번 구매 가능한 금액이라면, 로또를 한 번 구입할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {100, 101, 150, 199})
    void purchase_onlyOne(final int amount) {
        final Money initialAmount = Money.wons(amount);
        final LottoCustomer customer = new LottoCustomer(initialAmount);

        // Validate PreCondition
        assertThat(customer.canPurchase(lottoTicket1)).isTrue();
        assertThat(customer.getPurchasedCount()).isEqualTo(0);

        assertThat(customer.purchase(lottoTicket1)).isEqualTo(lottoTicket1.getFee());

        // Validate PostCondition
        assertThat(customer.canPurchase(lottoTicket1)).isFalse();
        assertThat(customer.getPurchasedCount()).isEqualTo(1);
        assertThat(customer.getPurchasedLottoTickets()).containsExactly(lottoTicket1);
    }

    @DisplayName("가진 금액으로, 구입 가능한 만큼, 로또를 구입 할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    void purchase_multiple(final int purchaseCount) {
        final Money initialAmount = lottoTicket1.getFee().multiply(Money.wons(purchaseCount));
        final LottoCustomer customer = new LottoCustomer(initialAmount);

        while (customer.canPurchase(lottoTicket1)) {
            customer.purchase(lottoTicket1);
        }

        assertThat(customer.getPurchasedCount()).isEqualTo(purchaseCount);
        assertThat(customer.getPurchasedLottoTickets()).contains(lottoTicket1);
    }

    @DisplayName("로또 구매전후로, 구입한 로또 번호 목록을 반환 할 수 있어야 한다")
    @Test
    void getPurchasedLottoNumbers() {
        assertThat(customer.getPurchasedCount()).isZero();
        assertThat(customer.getPurchasedLottoNumbers()).isEmpty();

        customer.purchase(lottoTicket1);

        assertThat(customer.getPurchasedCount()).isEqualTo(1);
        assertThat(customer.getPurchasedLottoNumbers())
            .containsExactly(LottoNumbers.of(1, 2, 3, 4, 5, 6));

        customer.purchase(lottoTicket2);

        assertThat(customer.getPurchasedCount()).isEqualTo(2);
        assertThat(customer.getPurchasedLottoNumbers())
            .containsExactly(
                LottoNumbers.of(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(45, 44, 43, 42, 41, 40));
    }
}