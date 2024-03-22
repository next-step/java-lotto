package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {

    @Test
    void price_exception() {
        assertThatThrownBy(() -> new Price(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("구입 금액은 %d원 이상이어야 합니다.", Rule.LOTTO_PRICE.getValue()));
    }

    @Test
    void price() {
        assertThat(new Price(1000)).isEqualTo(new Price(1000));
    }

}
