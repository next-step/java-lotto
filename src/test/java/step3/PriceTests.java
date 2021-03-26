package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Price;

public class PriceTests {

    @Test
    @DisplayName("입력 금액 테스트")
    public void priceTest() {
        Assertions.assertThatThrownBy(() -> new Price(400))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
