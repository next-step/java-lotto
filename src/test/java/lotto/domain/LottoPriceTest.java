package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPriceTest {
    @DisplayName("LottoPrice를 불변 객체로 생성한다.")
    @Test
    void create() {
        LottoPrice lottoPrice = new LottoPrice(2000);

        assertThat(lottoPrice)
                .isEqualTo(new LottoPrice(2000))
                .isNotSameAs(new LottoPrice(2000));
    }

    @DisplayName("로또 구입금액이 1000원 미만이면 IllegalArgumentException을 발생시킨다.")
    @Test
    void throw_IllegalArgumentException_when_purchaseAmount_is_underThan_1000() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoPrice(999))
                .withMessage("구입금액은 최소 1000원 이상이어야 합니다.");
    }

    @DisplayName("구매한 금액만큼 로또 갯수를 반환한다.")
    @Test
    void return_lottoTicketQuantity_purchased() {
        LottoPrice lottoPricePurchased = new LottoPrice(2000);

        int actual = lottoPricePurchased.countLottoPurchased();

        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("로또 금액을 float으로 반환한다.")
    @Test
    void return_float_type() {
        float actual = new LottoPrice(2000).floatValue();

        assertThat(actual).isEqualTo(2000.f);
    }
}
