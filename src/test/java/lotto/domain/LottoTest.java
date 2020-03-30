package lotto.domain;

import lotto.exception.NoPurchasePriceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @DisplayName("구입 금액에 해당하는 복권을 구매한다.")
    @Test
    void buy() {
        final Price price = new Price(2000);
        final int expect = 2;

        Lotteries actual = lotto.buy(price);

        assertThat(actual.count()).isEqualTo(expect);
    }

    @DisplayName("구입 금액이 로또 금액보다 작을 경우 NoPurchasePriceException 을 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void noPurchaseException(int price) {
        assertThatExceptionOfType(NoPurchasePriceException.class).isThrownBy(
                () -> lotto.buy(new Price(price))
        );
    }
}