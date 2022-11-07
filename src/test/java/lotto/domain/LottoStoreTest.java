package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    private static final Money LOTTO_FEE = Money.wons(100);
    private static final LottoNumbersSupplier lottoNumbersSupplier = new UniqueLottoNumbersSupplier();
    private static final List<LottoTicket> tickets = Arrays.asList(
        new LottoTicket(LOTTO_FEE, lottoNumbersSupplier.get()),
        new LottoTicket(LOTTO_FEE, lottoNumbersSupplier.get()),
        new LottoTicket(LOTTO_FEE, lottoNumbersSupplier.get())
    );
    private static LottoStore store;

    @BeforeEach
    void setUp() {
        store = new LottoStore(tickets);
    }

    @DisplayName("상점이 로또 티켓을 가지고 있지 않아, 고객에게 로또를 팔 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10, 100})
    void emptyLottoTickets(final int purchaseCount) {
        store = new LottoStore(Collections.emptyList());

        final LottoCustomer customer = new LottoCustomer(LOTTO_FEE.multiply(purchaseCount));

        assertThat(customer.getPurchasedCount()).isEqualTo(0);

        store.sellAllTo(customer);

        assertThat(customer.getPurchasedCount()).isEqualTo(0);
    }

    @DisplayName("고객의 가진 금액이 부족해, 로또를 팔 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 50, 99})
    void canNotSellAll(final int amount) {
        final LottoCustomer customer = new LottoCustomer(Money.wons(amount));

        assertThat(customer.getPurchasedCount()).isEqualTo(0);

        store.sellAllTo(customer);

        assertThat(customer.getPurchasedCount()).isEqualTo(0);
    }

    @DisplayName("고객의 가진 금액이 딱 로또 한 장을 살수 있는 금액이므로, 로또 한 장만 팔 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {100, 150, 199})
    void canSellOnlyOne(final int amount) {
        final LottoCustomer customer = new LottoCustomer(Money.wons(amount));

        assertThat(customer.getPurchasedCount()).isEqualTo(0);

        store.sellAllTo(customer);

        assertThat(customer.getPurchasedCount()).isEqualTo(1);
    }

    @DisplayName("고객의 가진 금액이, 로또 상점이 가지고 있는 모든 로또를 살수 있는 금액이라면, 상점이 가지고 있는 모든 로또를 살수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10, 100})
    void canSellAll(final int purchaseCount) {
        final LottoCustomer customer = new LottoCustomer(LOTTO_FEE.multiply((purchaseCount)));

        assertThat(customer.getPurchasedCount()).isEqualTo(0);

        store.sellAllTo(customer);

        assertThat(customer.getPurchasedCount()).isEqualTo(3);
    }
}