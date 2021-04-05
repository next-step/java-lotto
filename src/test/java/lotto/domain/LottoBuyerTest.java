package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoBuyerTest {
    private LottoStore lottoStore;
    private int payment;

    @BeforeEach
    public void setUp() {
        lottoStore = new LottoStore();
        payment = 10000;
    }

    @Test
    public void create() {
        assertThat(new LottoBuyer(lottoStore, payment)).isEqualTo(new LottoBuyer(lottoStore, payment));
    }

    @ParameterizedTest
    @ValueSource(ints = {-500, 0, 900})
    public void createWithPaymentLessThanPrice(int payment) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoBuyer(lottoStore, payment);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    public void validatePurchasable(int count) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final LottoBuyer lottoBuyer = new LottoBuyer(lottoStore, payment);

            lottoBuyer.validatePurchasable(count);
        });
    }
}
