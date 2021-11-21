package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {

    @Test
    void 금액을_입력한다() {
        //given
        Price price = Price.of(10000);
        //when
        //then
        assertThat(price).isNotNull();
    }

    @Test
    void 금액이_1000원_미만이면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Price.of(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액의_수익률을_계산한다() {
        //given
        Price price = Price.of(10000);
        //when
        float result = price.revenueOf(5000);
        //then
        assertThat(result).isEqualTo(0.5f);
    }
}
