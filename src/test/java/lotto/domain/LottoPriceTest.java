package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.exception.MoneyException;
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
    @DisplayName("구매할 때 로또 가격보다 낮은 금액을 입력하면 예외가 발생한다.")
    void buy_lotto_low_money_throw_exception() {
        LottoPrice lottoPrice = new LottoPrice();
        int money = 999;

        assertThatThrownBy(() -> lottoPrice.lottoCount(money))
            .isInstanceOf(MoneyException.class)
            .hasMessage("1000원 이하로는 구매할 수 없습니다.");
    }

    @Test
    @DisplayName("1000원 이상으로 구매할 경우 로또 개수를 반환한다.")
    void _1000over_get_lottoCount() {
        LottoPrice lottoPrice = new LottoPrice();

        assertThat(lottoPrice.lottoCount(2000)).isEqualTo(2);
    }

}