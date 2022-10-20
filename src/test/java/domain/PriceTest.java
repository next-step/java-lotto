package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {

    @Test
    void 금액은_마이너스를_입력할_수_없습니다() {
        assertThatThrownBy(() -> new Price(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액으로_금액을_나눌_수_있다() {
        assertThat(new Price(6000).divide(new Price(1000))).isEqualTo(6);
    }
}
