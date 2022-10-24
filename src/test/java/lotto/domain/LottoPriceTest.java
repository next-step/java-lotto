package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceTest {

    @Test
    @DisplayName("생성 테스트")
    void ctor_test() {
        assertThatNoException().isThrownBy(() -> new LottoPrice());
        assertThatNoException().isThrownBy(() -> new LottoPrice(1000));
    }

    @Test
    @DisplayName("구매할 때 로또 가격보다 낮은 금액을 입력하면 0개가 반환된다.")
    void buy_lotto_low_money_throw_exception() {
        LottoPrice lottoPrice = new LottoPrice();
        int money = 999;

        assertThat(lottoPrice.lottoCount(money)).isEqualTo(0);
    }

    @Test
    @DisplayName("1000원 이상으로 구매할 경우 로또 개수를 반환한다.")
    void _1000over_get_lottoCount() {
        LottoPrice lottoPrice = new LottoPrice();

        assertThat(lottoPrice.lottoCount(2000)).isEqualTo(2);
    }

}