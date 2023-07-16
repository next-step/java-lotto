package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(longs = {0L, 777L, 3_000L})
    @DisplayName("로또 금액을 정상적으로 생성한다.")
    void create(final long value) {
        /* given */

        /* when & then */
        assertDoesNotThrow(() -> new LottoMoney(value));
    }

    @Test
    @DisplayName("로또 금액의 값이 0보다 작을 경우 IllegalArgumentException을 던진다.")
    void createFailWithLessThanZeroValue() {
        /* given */
        final long value = -1_234L;

        /* when & then */
        assertThatThrownBy(() -> new LottoMoney(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또를 살 수 있는지 확인할 수 있다.")
    void payable() {
        /* given */
        final LottoMoney lottoMoney = new LottoMoney(1_234L);

        /* when & then */
        assertThat(lottoMoney.isPayable()).isTrue();
    }

    @Test
    @DisplayName("로또 금액이 로또 가격보다 작을 경우 로또를 구매할 수 없다.")
    void payableFail() {
        /* given */
        final LottoMoney lottoMoney = new LottoMoney(100L);

        /* when & then */
        assertThat(lottoMoney.isPayable()).isFalse();
    }

    @Test
    @DisplayName("로또 금액이 로또 가격보다 클 경우 로또를 구매한다.")
    void payLotto() {
        /* given */
        final LottoMoney lottoMoney = new LottoMoney(1_234L);

        /* when */
        final LottoMoney remain = lottoMoney.payLotto();

        /* then */
        assertThat(remain).isEqualTo(new LottoMoney(234L));
    }

    @Test
    @DisplayName("로또 금액이 로또 가격보다 작을 경우 IllegalStateException을 던진다.")
    void payLottoFailWithIllegalStateException() {
        /* given */
        final LottoMoney lottoMoney = new LottoMoney(100L);

        /* when & then */
        assertThatThrownBy(lottoMoney::payLotto).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("로또 금액의 배수를 구할 수 있다.")
    void multiply() {
        /* given */
        final LottoMoney lottoMoney = new LottoMoney(3_000L);
        final long operand = 3;

        /* when */
        LottoMoney result = lottoMoney.multiply(3);

        /* then */
        assertThat(result).isEqualTo(new LottoMoney(9_000L));
    }

    @Test
    @DisplayName("로또 금액 사이의 비율을 구할 수 있다.")
    void ratio() {
        /* given */
        final LottoMoney origin = new LottoMoney(3_000L);
        final LottoMoney target = new LottoMoney(10_000L);

        /* when */
        double ratio = origin.ratio(target);

        /* then */
        assertThat(ratio).isEqualTo(3_000L / (double) 10_000L);
    }

    @Test
    @DisplayName("로또 금액과 0 사이의 비율을 구하면 IllegalArgumentException을 던진다.")
    void ratioFailWithZero() {
        /* given */
        final LottoMoney origin = new LottoMoney(3_000L);
        final LottoMoney target = new LottoMoney(0L);

        /* when & then */
        assertThatThrownBy(() -> origin.ratio(target)).isInstanceOf(IllegalArgumentException.class);
    }
}
