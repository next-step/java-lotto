package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceTest {

    @DisplayName(value = "구매금액을 로또한개의 가격으로 나누었을때, 나머지가 발생할경우 IllegalArgumentException 발생한다.")
    @Test
    void checkValidPrice() {
        assertThatThrownBy(() -> new LottoPrice(10100))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
