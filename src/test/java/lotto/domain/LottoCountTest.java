package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoCountTest {

    @Test
    @DisplayName("로또 개수를 정상적으로 생성한다.")
    void create() {
        /* given */
        final int value = 5;

        /* when & then */
        assertDoesNotThrow(() -> new LottoCount(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-7, 0})
    @DisplayName("로또 개수가 0보다 작을 경우 IllegalException을 던진다.")
    void createFailWithLessThanZero(final int value) {
        /* given */

        /* when */
        assertThatThrownBy(() -> new LottoCount(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 개수로 총 로또 금액을 구할 수 있다.")
    void toTotalLottoPrice() {
        /* given */
        final LottoCount lottoCount = new LottoCount(3);

        /* when */
        LottoMoney totalPrice = lottoCount.toTotalLottoPrice();

        /* then */
        assertThat(totalPrice).isEqualTo(new LottoMoney(3_000L));
    }
}